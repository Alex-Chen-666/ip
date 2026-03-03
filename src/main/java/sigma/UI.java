package sigma;

import java.util.Scanner;
import java.util.ArrayList;
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
     * Display all tasks in the list.
     *
     * @param tasks The ArrayList of tasks.
     */
    public void printTasks(ArrayList<Task> tasks) {
        printLine();
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i).toString());
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
    /**
     * Display confirmation for task removal.
     *
     * @param task The removed task.
     * @param count The current number of tasks.
     */
    public void printTaskRemoved(Task task, int count) {
        printLine();
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + task.toString());
        System.out.println("     Now you have " + count + " tasks in the list.");
        printLine();
    }
    /**
     * Display the matching tasks found after a search.
     *
     * @param tasks The ArrayList of matching tasks.
     */
    public void printFoundTasks(ArrayList<Task> tasks) {
        printLine();
        if (tasks.isEmpty()) {
            System.out.println("     No matching tasks found in your list.");
        } else {
            System.out.println("     Here are the matching tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("     " + (i + 1) + "." + tasks.get(i).toString());
            }
        }
        printLine();
    }
}
