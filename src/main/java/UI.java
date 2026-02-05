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

    /**
     * Display all tasks in the list with their index.
     *
     * @param tasks The array containing tasks.
     * @param count The number of tasks in the array.
     */
    public void printTasks(Task[] tasks, int count) {
        printLine();
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i<count; i++) {
            System.out.println("     " + (i + 1) + "." + tasks[i].toString());
        }
        printLine();
    }
    public void printTaskAdded(Task task, int count) {
        printLine();
        System.out.println("     Got it. I've added this task:");
        System.out.println("       " + task.toString());
        System.out.println("     Now you have " + count + " tasks in the list.");
        printLine();
    }
}
