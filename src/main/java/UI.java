import java.util.Scanner;
/**
 * Handles interactions with the user.
 */
public class UI {
    private static final String LINE = "    ____________________________________________________________";
    private final Scanner input;
    public UI() {
        this.input = new Scanner(System.in);
    }
    /**
     * Prints the horizontal line separator.
     */
    public void printLine() {
        System.out.println(LINE);
    }

    public void printWelcome(String botName) {
        printLine();
        System.out.println("     Hello! I'm " + botName);
        System.out.println("     What can I do for you?");
        printLine();
    }

    public void printMessage(String message) {
        System.out.println("     " + message);
    }

    /**
     * Reads the next line of input from the user.
     * @return The full command entered by the user.
     */
    public String readCommand() {
        return input.nextLine();
    }

    public void printGoodbye() {
        printMessage("Bye. Hope to see you again soon!");
    }
}
