package sigma;

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
    public static boolean isUnmark(String input) {
        return input.trim().toLowerCase().startsWith("unmark");
    }
    /**
     * Check if the command is a todo.
     *
     * @param input Raw input.
     * @return true if it is a todo.
     */
    public static boolean isTodo(String input) {
        return input.trim().toLowerCase().startsWith("todo");
    }
    public static boolean isDeadline(String input) {
        return input.trim().toLowerCase().startsWith("deadline");
    }
    public static boolean isEvent(String input) {
        return input.trim().toLowerCase().startsWith("event");
    }
    /**
     * Extracts the description of a todo.
     *
     * @param input Full command.
     * @return Description string.
     * @throws SigmaException If description is missing.
     */
    public static String getTodoInfo(String input) throws SigmaException {
        String info = input.replaceFirst("(?i)todo", "").trim();
        if (info.isEmpty()) {
            throw new SigmaException("Please tell me the description of a todo.");
        }
        return info;
    }

    public static String[] getDeadlineInfo(String input) throws SigmaException {
        String content = input.replaceFirst("(?i)deadline", "").trim();
        if (content.isEmpty()) {
            throw new SigmaException("Please tell me the description of a deadline.");
        }
        if (!content.contains(" /by ")) {
            throw new SigmaException("A deadline needs a /by [time] component.");
        }
        String[] parts = content.split(" /by ");
        if (parts.length != 2 ) {
            throw new SigmaException("Deadline format: deadline [description] /by [time]");
        }
        return new String[]{parts[0].trim(),parts[1].trim()};
    }

    public static String[] getEventInfo(String input) throws SigmaException {
        String content = input.replaceFirst("(?i)event", "").trim();
        if (content.isEmpty()) {
            throw new SigmaException("Please tell me the description of an event.");
        }
        if (!content.contains(" /from ") || !content.contains(" /to ")) {
            throw new SigmaException("An event needs /from [start] and /to [end] components.");
        }
        String[] parts = content.split(" /from | /to ");
        if (parts.length != 3) {
            throw new SigmaException("Event format: event [desc] /from [start] /to [end]");
        }
        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
            throw new SigmaException("The description, start time, and end time cannot be empty.");
        }
        return new String[]{parts[0].trim(), parts[1].trim(), parts[2].trim()};
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