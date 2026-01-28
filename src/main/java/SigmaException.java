/**
 * exceptions specific to the Sigma chatbot.
 */
public class SigmaException extends Exception {
    /**
     * Constructs a new SigmaException with the specified detail message.
     *
     * @param message The error message.
     */
    public SigmaException(String message) {
        super(message);
    }
}