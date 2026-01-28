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
    /**
     * Returns true if the user input is the list command.
     *
     * @param input Full user input string.
     * @return true/false
     */
    public static boolean isList(String input) {
        return input.trim().equalsIgnoreCase("list");
    }
    /**
     * mark command
     *
     * @param input Raw user input.
     * @return true/false indicating if it is a mark command.
     */
    public static boolean isMark(String input) {
        return input.trim().toLowerCase().startsWith("mark");
    }
    /**
     * unmark command
     *
     * @param input Raw user input.
     * @return true/false indicating if it is an unmark command.
     */
    public static boolean isUnmark(String input) {
        return input.trim().toLowerCase().startsWith("unmark");
    }
    /**
     * Extract the integer index of the task to be marked/unmarked.
     *
     * @param input The full command.
     * @return The integer part.
     * @throws SigmaException If the input is not a valid integer.
     */
    public static int extractIndex(String input) throws SigmaException {
        try {
            String[] parts = input.trim().split(" ");
            return Integer.parseInt(parts[1]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new SigmaException("Please provide a valid task number.");
        }
    }
}