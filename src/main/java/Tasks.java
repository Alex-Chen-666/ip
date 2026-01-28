/**
 * Manage list of tasks.
 */
public class Tasks {
    private static final int MAX_TASKS = 100;
    /** store task descriptions */
    private final String[] tasks;
    /** Number of tasks currently in the list */
    private int taskCount;
    /** Constructor */
    public Tasks() {
        this.tasks = new String[MAX_TASKS];
        this.taskCount = 0;
    }
    /**
     * Add a task to the list.
     *
     * @param task The description of the task.
     */
    public void addTask(String task){
        tasks[taskCount] = task;
        taskCount++;
    }
    /**
     * Return the array of tasks.
     *
     * @return The array containing task descriptions.
     */
    public String[] getTasks() {
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