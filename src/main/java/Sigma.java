/**
 * Main class for the Sigma chatbot.
 */
public class Sigma {
    private final UI ui;
    private static final String BOT_NAME = "Sigma";
    private final Tasks tasks;
    /** Constructor */
    public Sigma() {
        ui = new UI();
        this.tasks = new Tasks();
    }
    /**
     * Starts the main loop of the chatbot.
     */
    public void run() {
        ui.printWelcome(BOT_NAME);
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();

                if (Parser.isExit(fullCommand)) { // User inputs 'bye'
                    isExit = true;
                    ui.printLine();
                    ui.printMessage("Bye. Hope to see you again soon!");
                    ui.printLine();
                } else if (fullCommand.isEmpty()) {  // Empty input
                    throw new SigmaException("Command cannot be empty!");
                } else if (Parser.isList(fullCommand)) {   // User inputs 'list'
                    ui.printTasks(tasks.getTasks(), tasks.getTaskCount());
                } else if (Parser.isMark(fullCommand)) { // Mark
                    int index = Parser.extractIndex(fullCommand);
                    Task selectedTask = tasks.getTask(index);
                    selectedTask.markAsDone();
                    ui.printLine();
                    ui.printMessage("Nice! I've marked this task as done:");
                    ui.printMessage(selectedTask.getString());
                    ui.printLine();
                } else if (Parser.isUnmark(fullCommand)) { // Unmark
                    int index = Parser.extractIndex(fullCommand);
                    Task selectedTask = tasks.getTask(index);
                    selectedTask.unmarkAsDone();
                    ui.printLine();
                    ui.printMessage("OK, I've marked this task as not done yet:");
                    ui.printMessage(selectedTask.getString());
                    ui.printLine();
                } else {
                    // Level 2 : Add and echo
                    Task newTask = new Task(fullCommand);
                    tasks.addTask(newTask);
                    ui.printLine();
                    ui.printMessage("added: " + fullCommand);
                    ui.printLine();
                }
            } catch (SigmaException e) {
                ui.printLine();
                ui.printMessage("Error: " + e.getMessage());
                ui.printLine();
            }
        }
    }

    public static void main(String[] args) {
        new Sigma().run();
    }
}