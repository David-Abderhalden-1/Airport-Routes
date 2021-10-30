package airRoutes.utils.common;

/**
 * The Edge class represents an edge of the AirNavigationGraph
 * and is only used by this graph. It stores a Vertex as well
 * as the weight of the edge.
 *
 * @see AirNavigationGraph
 *
 * @param <V> The value is the airport
 * @param <W> The weight of the edge
 *
 * @author David Abderhalden / Joris Hänseler
 * @version 0.1
 * @since 28.10.2021
 */
public class Edge<V, W>{
    final V value;
    W weight;
    public Edge(V value, W weight){
        this.value = value;
        this.weight = weight;
    }
}
