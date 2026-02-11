package sigma;

/**
 * Manage list of tasks.
 */
public class Tasks {
    private static final int MAX_TASKS = 100;
    /** store task descriptions */
    private final Task[] tasks;
    /** Number of tasks currently in the list */
    private int taskCount;
    /** Constructor */
    public Tasks() {
        this.tasks = new Task[MAX_TASKS];
        this.taskCount = 0;
    }
    /**
     * Add a task to the list.
     *
     * @param task The description of the task.
     */
    public void addTask(Task task){
        tasks[taskCount] = task;
        taskCount++;
    }
    /**
     * Return a specific task (1-based index).
     *
     * @param index The index of the task.
     * @return The Task object at that index.
     */
    public Task getTask(int index) throws SigmaException {
        if (index <= 0 || index > taskCount) {
            throw new SigmaException("Invalid task number.");
        }
        return tasks[index - 1];
    }
    /**
     * Return the array of tasks.
     *
     * @return The array containing task descriptions.
     */
    public Task[] getTasks() {
        return tasks;
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The count of valid tasks.
     */
    public int getTaskCount() {
        return taskCount;
    }
}