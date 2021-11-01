package airRoutes.utils.common;

import airRoutes.utils.Airport;

/**
 * The QueueBucket class is needed for the Dijkstra algorithm.
 * It describes a part of a route and is comparable.
 *
 * @see AirNavigationGraph
 *
 * @author David Abderhalden / Joris Hänseler
 * @version 0.1
 * @since 30.10.2021
 */
public class QueueBucket implements Comparable<QueueBucket>{
    private final Airport vertex;
    private int routeLength;
    private Airport lastVertex;

    public QueueBucket(Airport vertex, int weight, Airport lastVertex){
        this.vertex = vertex;
        this.routeLength = weight;
        this.lastVertex = lastVertex;
    }

    //Getter
    public Airport getVertex() {
        return vertex;
    }

    public int getRouteLength() {
        return routeLength;
    }

    public Airport getLastVertex() {
        return lastVertex;
    }

    //Setter

    public void setRouteLength(int routeLength) {
        this.routeLength = routeLength;
    }

    public void setLastVertex(Airport lastVertex) {
        this.lastVertex = lastVertex;
    }

    @Override
    public int compareTo(QueueBucket other) {
        return Integer.compare(this.routeLength, other.getRouteLength());
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null) return false;
        if (!(obj instanceof Airport)) return false;

        Airport airport = (Airport) obj;

        return airport.equals(this.vertex);
    }
}
