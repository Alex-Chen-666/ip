/**
 * Parse user input into meaningful instructions.
 */
public class Parser {
    /**
     * Returns true if the user input is the exit command.
     *
     * @param input Full user input string.
     * @return true/false
     */
    public static boolean isExit(String input) {
        return input.trim().equalsIgnoreCase("bye");
    }
}