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
    private double routeLength;
    private Airport lastVertex;

    public QueueBucket(Airport vertex, double weight, Airport lastVertex){
        this.vertex = vertex;
        this.routeLength = weight;
        this.lastVertex = lastVertex;
    }

    //Getter
    public Airport getVertex() {
        return vertex;
    }

    public double getRouteLength() {
        return routeLength;
    }

    public Airport getLastVertex() {
        return lastVertex;
    }

    //Setter
    public void setRouteLength(double routeLength) {
        this.routeLength = routeLength;
    }

    public void setLastVertex(Airport lastVertex) {
        this.lastVertex = lastVertex;
    }

    @Override
    public int compareTo(QueueBucket other) {
        return Double.compare(this.routeLength, other.getRouteLength());
    }
}
