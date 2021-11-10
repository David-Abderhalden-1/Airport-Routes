package airRoutes.utils.common;

import airRoutes.utils.Airport;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * This class is responsible for loading csv files,
 * parsing them and writing the data into a graph.
 *
 * @author David Abderhalden / Joris Hänseler
 * @version 0.1
 * @since 04.11.2021
 */
public class FileHandler {
    //The csv delimiter
    private final static String delimiter = ";";

    /**
     * Creates a stream to the file and loads it into
     * a buffered reader
     * @param path The file path
     * @return if successful -> buffered reader, else null
     */
    private static BufferedReader readFile(String path){
        try{
            File file = new File(path);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(file), StandardCharsets.UTF_8);
            return new BufferedReader(reader);
        } catch (IOException e){
            ConsoleInteractions.errorMessage(1);
        }
        return null;
    }

    /**
     * Writes loaded vertex data into the graph.
     * airport country, airport location, airport name, airport abbreviation
     *
     * @param inputGraph The graph in which the vertex should be loaded
     * @throws IOException if the buffered reader is empty
     */
    public static void getVertex(AirNavigationGraph inputGraph) throws IOException {
        BufferedReader reader = readFile("src/airRoutes/docs/data/vertex.CSV");
        if(reader == null) return;
        while (reader.ready()) {
            String[] parsedCsv = reader.readLine().split(delimiter);

            //TODO: Optional, implement try -> catch
            String country = parsedCsv[0]; String location = parsedCsv[1];
            String name = parsedCsv[2]; String abbreviation = parsedCsv[3];

            inputGraph.addVertex(new Airport(country, location, name, abbreviation));
        }
    }

    /**
     * Connects vertex in the graph with edges
     * start abbreviation, end abbreviation, duration, directional
     *
     * @param inputGraph The graph in which the edge should be constructed
     * @throws IOException if the buffered reader is empty
     */
    public static void getEdges(AirNavigationGraph inputGraph) throws IOException {
        BufferedReader reader = readFile("src/airRoutes/docs/data/edges.csv");
        if(reader == null) return;
        while (reader.ready()) {
            String[] parsedCsv = reader.readLine().split(delimiter);

            //TODO: Optional, implement try -> catch
            String startAbbreviation = parsedCsv[0]; String endAbbreviation = parsedCsv[1];
            double duration = Double.parseDouble(parsedCsv[2]); boolean directional = Boolean.parseBoolean(parsedCsv[3]);

            Airport startAirport = inputGraph.getAirportFromAbbreviation(startAbbreviation);
            Airport endAirport = inputGraph.getAirportFromAbbreviation(endAbbreviation);

            inputGraph.addEdge(startAirport, endAirport, duration, directional);
        }
    }
}
