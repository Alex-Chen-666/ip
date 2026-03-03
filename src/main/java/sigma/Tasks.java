package sigma;
import java.util.ArrayList;
/**
 * Manage list of tasks.
 */
public class Tasks {
    private final ArrayList<Task> tasks;
    /** Constructor */
    public Tasks() {
        this.tasks = new ArrayList<>();
    }
    /**
     * Add a task to the list.
     *
     * @param task The Task object to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }
    /**
     * Remove a task from the list.
     *
     * @param index The 1-based index of the task.
     * @return The removed Task object.
     * @throws SigmaException If the index is out of valid range.
     */
    public Task deleteTask(int index) throws SigmaException {
        try {
            return tasks.remove(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new SigmaException("Invalid task number.");
        }
    }
    /**
     * Return a specific task (1-based index).
     *
     * @param index The index of the task.
     * @return The Task object at that index.
     * @throws SigmaException If the index is out of bounds.
     */
    public Task getTask(int index) throws SigmaException {
        try {
            return tasks.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new SigmaException("Invalid task number.");
        }
    }
    /**
     * Return the count of tasks in the list.
     *
     * @return The size of the ArrayList.
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Return the internal ArrayList of tasks.
     *
     * @return The ArrayList.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Find and return a list of tasks containing the given keyword.
     *
     * @param keyword The string to search for in task descriptions.
     * @return An ArrayList of matching Task objects.
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> filteredTasks = new ArrayList<>();
        for (Task t : tasks) {
            if (t.toString().contains(keyword)) {
                filteredTasks.add(t);
            }
        }
        return filteredTasks;
    }
}