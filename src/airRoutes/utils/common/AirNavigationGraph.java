package airRoutes.utils.common;

import airRoutes.utils.Airport;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This Class represents an adjacency list implementation of a graph.
 * It links multiple airports together making use of a HashMap and Edges.
 * Vertex can be linked directionally as well as undirectionally.
 *
 * @author David Abderhalden / Joris Hänseler
 * @version 0.1
 * @since 30.10.2021
 */
public class AirNavigationGraph {
    private Map<Airport, LinkedList<Edge<Airport, Integer>>> graph;

    /**
     * constructor
    */
    public AirNavigationGraph(){
        this.graph = new HashMap<>();
    }

    /**
     * Adds an airport as a new vertex to the graph
     * @param vertex the specific airport
     */
    public void addVertex(Airport vertex){
        //TODO: Implement
    }

    /**
     * Removes an airport as a vertex from the graph
     * @param vertex the specific airport
     */
    public void removeVertex(Airport vertex){
        //TODO: Implement
    }

    /**
     * Adds a new edge to the graph
     * @param firstVertex the first airport of the connection (if directional this will be the start vertex)
     * @param lastVertex the second airport of the connection (if directional this will be the destination vertex)
     * @param weight the weight of the edge
     * @param directional true if directional, false if undirectional
     */
    public void addEdge(Airport firstVertex, Airport lastVertex, int weight, boolean directional){
        //TODO: Implement
    }

    /**
     * Removes an edge from the graph
     * @param firstVertex the first airport of the connection (if directional this will be the start vertex)
     * @param lastVertex the second airport of the connection (if directional this will be the destination vertex)
     * @param directional type of removal, true ignores direction
     */
    public void removeEdge(Airport firstVertex, Airport lastVertex, boolean directional){
        //TODO: Implement
    }

    /**
     * Implementation of Dijkstas fastest route
     * @param departure the airport of departure
     * @param destination the airport of arrival
     */
    public void route(Airport departure, Airport destination){
        //TODO: Implement
        //This is going to contain the dijkstas fastest route algorithm
    }

    /**
     * modifies the weight of the edge (both directions if undirectional)
     * @param firstVertex the first airport of the connection
     * @param lastVertex the second airport of the connection
     */
    public void alterWeight(Airport firstVertex, Airport lastVertex){
        //TODO: Implement
    }
}
