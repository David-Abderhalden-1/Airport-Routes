package airRoutes.utils.common;

import airRoutes.utils.Airport;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileHandler {
    private final static String delimiter = ";";

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

    public static AirNavigationGraph getVertex(AirNavigationGraph inputGraph) throws IOException {
        BufferedReader reader = readFile("src/airRoutes/docs/data/vertex.CSV");
        if(reader == null) return inputGraph;
        while (reader.ready()) {
            String[] parsedCsv = reader.readLine().split(delimiter);

            //TODO: Optional, implement try -> catch
            String country = parsedCsv[0]; String location = parsedCsv[1];
            String name = parsedCsv[2]; String abbreviation = parsedCsv[3];

            inputGraph.addVertex(new Airport(country, location, name, abbreviation));
        }
        return inputGraph;
    }

    public static AirNavigationGraph getEdges(AirNavigationGraph inputGraph) throws IOException {
        BufferedReader reader = readFile("src/airRoutes/docs/data/edges.csv");
        if(reader == null) return inputGraph;
        while (reader.ready()) {
            String[] parsedCsv = reader.readLine().split(delimiter);

            //TODO: Optional, implement try -> catch
            String startAbbreviation = parsedCsv[0]; String endAbbreviation = parsedCsv[1];
            double duration = Double.parseDouble(parsedCsv[2]); boolean directional = Boolean.parseBoolean(parsedCsv[3]);

            Airport startAirport = inputGraph.getAirportFromAbbreviation(startAbbreviation);
            Airport endAirport = inputGraph.getAirportFromAbbreviation(endAbbreviation);

            inputGraph.addEdge(startAirport, endAirport, duration, directional);
        }
        return inputGraph;
    }
}
