# Sigma - CLI Task Management Chatbot

Sigma is a Java-based chatbot designed to help users manage tasks efficiently through a Command Line Interface (CLI). It supports various task types, including Todos, Deadlines, and Events, featuring full persistence and keyword search capabilities.

---

## 📖 Documentation

The official **User Guide** for Sigma is available online via GitHub Pages:

👉 **[View the Sigma User Guide](https://alex-chen-666.github.io/ip/)**

---

## 🛠️ Setting up in IntelliJ

Prerequisites: **JDK 17** (strictly required), and the latest version of IntelliJ IDEA.

1. **Open the project**:
   - Launch IntelliJ IDEA.
   - Click `Open`.
   - Select the project root directory and click `OK`.

2. **Configure SDK**:
   - Go to `File` > `Project Structure` > `Project`.
   - Ensure the **SDK** is set to **JDK 17**.
   - Set the **Project language level** to `17` or `SDK default`.

3. **Run the Application**:
   - Locate the main class at `src/main/java/sigma/Sigma.java`.
   - Right-click the file and choose `Run 'Sigma.main()'`.
   - You should see the welcome message from Sigma in the console.

---

## 🚀 Key Features

*   **Task Management**: Add, delete, and list tasks.
*   **Task Types**: Support for `todo`, `deadline` (with dates), and `event` (with duration).
*   **Status Tracking**: Mark tasks as done (`mark`) or not done yet (`unmark`).
*   **Keyword Search**: Quickly find tasks using the `find` command.
*   **Auto-Save**: All data is automatically saved to `data/sigma.txt` and loaded upon startup.
*   **Robust Error Handling**: Specific error messages for invalid inputs or corrupted data files.

---

## 📂 Project Structure

Sigma follows a modular OOP architecture.
All source files are organized within a single package: `sigma`.

*   `Sigma`: The main entry point of the application.
*   `UI`: Handles all user interactions and console output.
*   `Parser`: Interprets and validates user commands.
*   `Tasks`: Manages the in-memory task list using an `ArrayList`.
*   `Storage`: Handles loading from and saving tasks to the hard disk.
*   `Task`: The base class for all task types.
*   `Todo`, `Deadline`, `Event`: Specific task subclasses inheriting from `Task`.
*   `SigmaException`: Custom exception class for chatbot-specific errors.