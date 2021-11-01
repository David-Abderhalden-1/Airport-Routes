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
        Airport A = new Airport("Aland", "landland", "aaaairport", "airy");
        Airport B = new Airport("Bland", "guggeligutsch", "Wasserhose", "WH");
        Airport C = new Airport("Cland", "landland", "aaaairport", "airy");
        Airport D = new Airport("Dland", "Dnew", "Sodastream", "Senistake");
        Airport E = new Airport("Eland", "Oryyx", "LADE", "LADE");
        Airport F = new Airport("Fland", "Fischen-hausen", "Forelle", "gebratene Forelle");
        Airport G = new Airport("Gland", "Gringor", "airport Gringor", "telegarger");
        Airport H = new Airport("Hland", "CSS", "digitales Simsen", "Simsen");
        Airport I = new Airport("Iland", "rennes", "Vögels", "VÖ");
        Airport J = new Airport("Jland", "<Jogi>", "Ja perfekt machsch du das", "JPMDD");
        Airport K = new Airport("Kland", "landland", "aaaairport", "airy");
        Airport L = new Airport("Lland", "Landandandand", "Anden", "And");
        Airport M = new Airport("Mland", "Mamma Mia!", "Mammmmma", "Mam'");
        Airport N = new Airport("Nland", "Nasen-hausen", "Hasen", "Langohrhasen");
        Airport O = new Airport("Oland", "Applejuice", "Veronica der Lentz ist da... Autsch! Nein, Hilfe stop!", "Verre'");
        Airport P = new Airport("Pland", "Plan B", "Plan A", "funckin' Pland");

        AirNavigationGraph graph = new AirNavigationGraph();

        graph.addEdge(A, B, 2, false);
        graph.addEdge(B, P, 1, false);
        graph.addEdge(P, O, 1, false);
        graph.addEdge(O, B, 1, false);
        graph.addEdge(O, M, 0.5, false);
        graph.addEdge(M, C, 1, false);
        graph.addEdge(C, A, 2, false);
        graph.addEdge(C, L, 1, false);
        graph.addEdge(M, N, 8, false);
        graph.addEdge(N, J, 3, false);
        graph.addEdge(J, I, 3, false);
        graph.addEdge(I, D, 4, false);
        graph.addEdge(D, K, 1, false);
        graph.addEdge(D, A, 2, false);
        graph.addEdge(J, H, 8, false);
        graph.addEdge(H, G, 1, false);
        graph.addEdge(H, D, 1, false);
        graph.addEdge(G, F, 2, false);
        graph.addEdge(F, E, 1, false);
        graph.addEdge(E, G, 1, false);
        graph.addEdge(E, H, 3, false);
        graph.addEdge(A, E, 2, false);
        graph.addEdge(A, H, 4, false);

        graph.route(N, F);
    }
}
