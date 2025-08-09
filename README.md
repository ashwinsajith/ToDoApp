# ToDoApp-README first

This IntelliJ project implements the idea of a simple To-Do List using Java.
It 
consists of three main classes:
1. *Task.java*: This class represents the working of a 'Task' object in the 
   application. It stores a task's  title, due date and completion 
   status. It also provides methods to check, update and compare tasks.  
   
**Instance fields**: 
- **String title** - The name of the task.
- **boolean isDone** - The completion status of the task.
- **LocalDate dueDate** - The due date of the task. <br>

**Constructor**:
**Task (String title, 
  boolean isDone, LocalDate dueDate)** 


  **Instance methods**: 
  - **toString()** - Overrides Object.toString() and returns a String 
    representation of the task.
- **getTitle()** - Returns the title of the task.
 - **getDueDate()** - Returns the due date of the task.
- **isCompleted()** - Returns the completion status of the task.
- **isOverdue()** - Returns whether the task is overdue or not.
- **equals()** - Overrides Object.equals() and compares tasks on the basis of 
title, due date and completion status.

***

2. *ToDoList.java*: This class represents the ToDoList itself. It manages a 
   collection of Task objects and provides 
   methods to add, remove, update and list tasks.

**Instance field**: 

- **ArrayList<Task> tasks** -  Stores tasks in insertion order.

**Constructor**: **ToDoList()** 

**Instance methods**: 
- **addTask(Task task)** - Adds a given task.
- **removeTask(Task task)** - Removes a specified task.
-  **listTasks()** - Prints a numbered list of all tasks with status and due date.
- **markCompleted(Task task)** - Marks a given task as completed.
- **listOverdue()** - Returns all the overdue tasks.

***

3. *Main.java*: The entry point of the application. It uses a command-line 
   interface to perform five 
  operations: 
- Add Task 
- Remove Task 
- List Tasks 
- Mark a Task Completed
- List Overdue Tasks

**Additional static methods**: 
- **getInput()** - Displays the menu options and safely accepts and returns 
  the user's input.
- **askToContinue(Scanner scanner)** - Prompts the user to continue or exit 
  the program and validate the answer.

**Error Handling**: 
- Multiple try-catch blocks to validate integer, boolean and date data types.
- Invalid input prompts the user to enter a valid input again.

**User Experience**:
- Displays clear error messages when needed and appropriate prompts for the 
  same.
- Shows a goodbye message when the user wants to exit the application.