package airRoutes;

import airRoutes.utils.Airport;
import airRoutes.utils.common.AirNavigationGraph;
import airRoutes.utils.common.ConsoleInteractions;
import airRoutes.utils.common.FileHandler;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeMap;

/**
 * ---------------------- Air Route Flight ----------------------
 * Welcome to Air Routes. This program was designed for our final
 * mini project of Module 411 (Datastructures and Algorithms).
 * In this project we will implement a graph which contains
 * directional as well as undirectional edges. These edges
 * represent the flight routes between airports. They have given
 * weights (which can be modified).
 * With help of "Dijkstras shortest path" algorithm the user will
 * be able to calculate the most practical route.
 *
 * More Information can be found in: README.md
 * A detailed illustration of our graph can be found in: ...
 *
 * @author David Abderhalden / Joris Hänseler
 * @version 0.1
 * @since 28.10.2021
 */
public class AirRoutes {
    private AirNavigationGraph graph;

    /**
     * Program entry method
     * @param args Program variables
     */
    public static void main(String[] args){
        AirRoutes airRoutes = new AirRoutes();
        airRoutes.airRoutes();
    }

    /**
     * This is the method which controls the whole program.
     */
    private void airRoutes(){
        // Initialisations
        TreeMap<String, String> mainMenu = new TreeMap<>(String.CASE_INSENSITIVE_ORDER){{
            put("A","Display Route");
            put("B", "Display Graph");
            put("C","Register Delay");
            put("D"," -> Exit");
        }};

        // Load graph from file
        // TODO: Print caption
        try{
            // TODO: print loading bar
            this.graph = initializeGraph();
        }catch (IOException e){
            ConsoleInteractions.errorMessage(2);
        }

        while(true){
            switch(ConsoleInteractions.menu(mainMenu).toLowerCase()){
                case "a" : getRoute(); break;
                case "b" : this.graph.display(); break;
                case "c" : registerDelay(); break;
                case "d" : System.exit(0); break;
            }
        }
    }

    private void registerDelay(){
        Airport airNo1, airNo2; double newDuration = -1;
        do{
            ConsoleInteractions.write("\n--------- ENTER THE DATA ---------", true);
            Airport[] endPoints = checkAbbreviation();
            airNo1 = endPoints[0]; airNo2 = endPoints[1];

            try{
                newDuration = Double.parseDouble(Objects.requireNonNull(ConsoleInteractions.read("Enter the new duration: ")));
            }catch (NumberFormatException e){
                ConsoleInteractions.errorMessage(3);
            }

        }while (airNo1 == null || airNo2 == null || newDuration == -1);

        if(this.graph.alterWeight(airNo1, airNo2, newDuration)){
            ConsoleInteractions.write("Duration was successfully altered!", true);
        }
        else {
            ConsoleInteractions.write(
                    "Duration couldn't be altered ... this is probably due to the none existing route between the two airports", true);
        }
    }

    private AirNavigationGraph initializeGraph() throws IOException {
        AirNavigationGraph graph = new AirNavigationGraph();
        FileHandler.getVertex(graph);
        FileHandler.getEdges(graph);
        return graph;
    }

    private void getRoute() {
        Airport airNo1, airNo2;
        do{
            ConsoleInteractions.write("\n--------- ENTER THE START AND END ---------", true);
            Airport[] endPoints = checkAbbreviation();
            airNo1 = endPoints[0]; airNo2 = endPoints[1];

        }while (airNo1 == null || airNo2 == null);

        this.graph.route(airNo1, airNo2);
    }

    private Airport[] checkAbbreviation() {
        String abbrevNo1 =
                Objects.requireNonNull(ConsoleInteractions.read("Enter the first airport abbreviation: ")).toUpperCase();
        String abbrevNo2 =
                Objects.requireNonNull(ConsoleInteractions.read("Enter the second airport abbreviation: ")).toUpperCase();

        Airport airNo1 = this.graph.getAirportFromAbbreviation(abbrevNo1);
        if (airNo1 == null) {
            ConsoleInteractions.errorMessage(4);
        }

        Airport airNo2 = this.graph.getAirportFromAbbreviation(abbrevNo2);
        if (airNo2 == null) {
            ConsoleInteractions.errorMessage(4);
        }

        return new Airport[]{airNo1, airNo2};
    }
}
