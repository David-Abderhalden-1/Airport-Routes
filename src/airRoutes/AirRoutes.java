package airRoutes;

import airRoutes.utils.Airport;
import airRoutes.utils.common.AirNavigationGraph;
import airRoutes.utils.common.ConsoleInteractions;
import airRoutes.utils.common.FileHandler;

import java.io.IOException;
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
        // print caption
        AirNavigationGraph graph = null;
        try{
            // print loading bar
            graph = initializeGraph();
        }catch (IOException e){
            ConsoleInteractions.errorMessage(2);
        }

        Airport a = graph.getAirportFromAbbreviation("MAD");
        Airport b = graph.getAirportFromAbbreviation("FRA");
        graph.route(a, b);
    }

    private AirNavigationGraph initializeGraph() throws IOException {
        AirNavigationGraph graph = new AirNavigationGraph();
        FileHandler.getVertex(graph);
        FileHandler.getEdges(graph);
        return graph;
    }
}
