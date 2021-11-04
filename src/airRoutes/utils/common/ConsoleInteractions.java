package airRoutes.utils.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * This class is designed as a basic user interaction system
 * that is designed to occur over the console.
 *
 * @author David Abderhalden / Joris Hänseler
 * @version 0.1
 * @since 28.10.2021
 */
public class ConsoleInteractions {

    /**
     * This class is storing all the error messages and will display them on
     * This class is storing all the error messages and will display them on
     * command from an id.
     * @param id The index where the error message is stored
     * @return The error message as a type String
     */
    public static void errorMessage(int id){
        try{
            String[] errors = new String[]{
                    "An unexpected error occurred while reading the user input",
                    "A file could not be read, please contact the support",
                    "The default graph could not be loaded. This likely due to an internal Error"
            };
            write(errors[id], true);
        }catch (NullPointerException e){
            write( "Cannot find error message with ID "+id, true);
        }
    }

    /**
     * This method outputs text to the console
     * @param text the text to be outputted
     */
    public static void write(String text, boolean newLine){
        if(newLine) System.out.println(text);
        else System.out.print(text);
    }

    /**
     * The method makes use of a BufferedReader and reads
     * the user input.
     * @param text is optional and can be used as an output
     * @return the user input
     */
    public static String read(String text){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        write(text, false);
        try{
            return bufferedReader.readLine();
        }catch (IOException e){
            errorMessage(1);
        }
        return null;
    }

    /**
     * This method will provide a small menu. It will generate
     * some an option and text from a HashMap (option can be
     * number or letter or even word)
     * @param options the treemap with option and text
     * @return the chosen user option
     */
    public static String menu(TreeMap<String, String> options){
        String response;
        do{
            write("\n--------- CHOOSE YOUR ACTION ---------", true);
            options.forEach((key, value) -> write(key+") "+value, true));
            response = read("\nPlease choose your option: ");
        }while (!options.containsKey(response));
        return response;
    }
}
