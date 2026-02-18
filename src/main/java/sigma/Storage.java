package sigma;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Handle loading and saving tasks to a file on the hard disk.
 */
public class Storage {
    private final String filePath;

    /**
     * Constructor. Initialize Storage with a file path.
     *
     * @param filePath The relative path to the data file.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Save the current task list to the hard disk.
     *
     * @param tasks The current Tasks object.
     * @throws SigmaException If an I/O error occurs.
     */
    public void save(Tasks tasks) throws SigmaException {
        try {
            File file = new File(filePath);
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            FileWriter fw = new FileWriter(file);
            Task[] allTasks = tasks.getTasks();
            for (int i = 0; i < tasks.getTaskCount(); i++) {
                fw.write(allTasks[i].toFileFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            throw new SigmaException("Could not save tasks: " + e.getMessage());
        }
    }

    /**
     * Load tasks from the hard disk into the Tasks object.
     *
     * @param tasks The Tasks object to populate.
     * @throws SigmaException If the file is corrupted.
     */
    public void load(Tasks tasks) throws SigmaException {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }

        try (Scanner s = new Scanner(file)) {
            while (s.hasNext()) {
                String line = s.nextLine();
                String[] parts = line.split(" \\| ");

                // Stretch goal
                if (parts.length < 3) {
                    continue;
                }

                Task t;
                switch (parts[0]) {
                case "T":
                    t = new Todo(parts[2]);
                    break;
                case "D":
                    t = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    t = new Event(parts[2], parts[3], parts[4]);
                    break;
                default:
                    continue;
                }

                if (parts[1].equals("1")) {
                    t.markAsDone();
                }
                tasks.addTask(t);
            }
        } catch (IOException e) {
            throw new SigmaException("Error loading file.");
        }
    }
}