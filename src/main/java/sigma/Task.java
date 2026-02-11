package sigma;

/**
 * a task with a description and completion status.
 */
public class Task {
    /** Description of the task */
    protected String description;
    /** Completion status of the task */
    protected boolean isDone;
    /**
     * Initialize a task
     *
     * @param description The content of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Return the status icon depending on whether the task is done.
     *
     * @return A string representing the status("X" for done," " for not done)
     */
    public String getStatusIcon() {
        return (isDone?"X":" ");
    }
    /**
     * Mark the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }
    /**
     * Mark the task as not done.
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }
    /**
     * Return a string representation of the task including status.
     *
     * @return The formatted string of the task.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}