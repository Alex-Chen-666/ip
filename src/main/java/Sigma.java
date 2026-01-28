/**
 * Main class for the Sigma chatbot.
 */
public class Sigma {
    private final UI ui;
    private static final String BOT_NAME = "Sigma";
    // Constructor
    public Sigma() {
        ui = new UI();
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
                    ui.printGoodbye();
                    ui.printLine();
                } else if (fullCommand.isEmpty()) {  // Empty input
                    throw new SigmaException("Command cannot be empty!");
                } else {
                    // Level 1 Echo logic
                    ui.printLine();
                    ui.printMessage(fullCommand);
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