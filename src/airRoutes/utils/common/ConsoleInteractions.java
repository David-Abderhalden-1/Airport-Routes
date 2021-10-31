package airRoutes.utils.common;

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
     * This method outputs text to the console
     * @param text the text to be outputted
     */
    public static void write(String text){
        // TODO: Implement
    }

    /**
     * The method makes use of a BufferedReader and reads
     * the user input.
     * @param text is optional and can be used as an output
     * @return the user input
     */
    public static String read(String text){
        // TODO: Implement
        return null;
    }

    /**
     * This method will provide a small menu. This will generate
     * some index and text where the user can then decide, which
     * option he wants to pick.
     * @param options the different options a user has (ordered by array).
     * @return the user option as index
     */
    public static int menu(String[] options){
        // TODO: Implement (if user invalid option, catch and do again)
        return 0;
    }
}
