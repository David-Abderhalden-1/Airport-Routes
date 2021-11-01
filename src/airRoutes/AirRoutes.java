package airRoutes;

import airRoutes.utils.Airport;
import airRoutes.utils.common.AirNavigationGraph;

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
        Airport A = new Airport("Aland", "Acity", "A", "AAA");
        Airport B = new Airport("Bland", "Bcity", "B", "BBB");
        Airport C = new Airport("Cland", "Ccity", "C", "CCC");
        Airport D = new Airport("Dland", "Dcity", "D", "DDD");
        Airport E = new Airport("Eland", "Ecity", "E", "EEE");
        Airport F = new Airport("Fland", "Fcity", "F", "FFF");
        Airport G = new Airport("Gland", "Gcity", "G", "GGG");

        AirNavigationGraph graph = new AirNavigationGraph();
        graph.addEdge(A, B, 1, false);
        graph.addEdge(B, C, 3, false);
        graph.addEdge(B, D, 1, false);
        graph.addEdge(D, C, 1, false);
        graph.addEdge(A, F, 1, false);
        graph.addEdge(F, G, 3, false);
        graph.addEdge(G, E, 2, false);
        graph.addEdge(E, F, 2, false);
        graph.addEdge(E, B, 3, false);

        graph.route(B, C);
    }
}
