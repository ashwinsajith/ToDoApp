import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static  void main(String[] args){
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Mark a Task as Completed");
        System.out.println("5. List Overdue Tasks");
        System.out.println();
        Scanner inputObject=new Scanner(System.in);
        int input;
        while (true) {
            try {
                System.out.print("Enter your input choice: ");
                input = inputObject.nextInt();
                inputObject.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                inputObject.nextLine();
            }
        }
        boolean choice=true;
        ToDoList taskList=new ToDoList();
        while(choice){
            if (input==1){
                String name;
                System.out.print("Enter the title of the new task: ");
                name=inputObject.nextLine();


                LocalDate date;
                while (true){
                    try{
                        System.out.print("Enter the due date of the new task(YYYY-MM-DD): ");
                        String dateString=inputObject.nextLine();
                        date=LocalDate.parse(dateString);
                        break;
                    } catch (DateTimeParseException e){
                        System.out.println("Invalid input. Enter a date in the correct format.");
                    }
                }


                boolean isCompleted;
                while (true){
                    System.out.print("Enter if the task is completed or not(true/false): ");
                    String done=inputObject.nextLine();
                    if (done.toLowerCase().equals("true")){
                        isCompleted=true;
                        break;
                    } else if (done.toLowerCase().equals("false")) {
                        isCompleted=false;
                        break;
                    }else{
                        System.out.println("Invalid input. Enter true or false.");
                    }
                }

                Task newTask=new Task(name,isCompleted,date);
                taskList.addTask(newTask);
                choice=askToContinue(inputObject);
                if (choice){
                    input = getInput();
                }else{
                    System.out.println("Goodbye! Your tasks are safe and waiting to see you in the future.");
                    break;
                }


            } else if (input==2) {

                String name;
                System.out.print("Enter the title of the task to remove: ");
                name=inputObject.nextLine();


                LocalDate date;
                while (true){
                    try {
                        System.out.print("Enter the due date of the task to remove(YYYY-MM-DD): ");
                        String dateString = inputObject.nextLine();
                        date = LocalDate.parse(dateString);
                        break;
                    }catch (DateTimeParseException e){
                        System.out.println("Invalid input. Enter a date in the correct format.");
                    }
                }


                boolean isCompleted;

                while (true){
                    System.out.print("Enter if the task is completed or not(true/false): ");
                    String done=inputObject.nextLine();
                    if (done.toLowerCase().equals("true")){
                        isCompleted=true;
                        break;
                    } else if (done.toLowerCase().equals("false")) {
                        isCompleted=false;
                        break;
                    }else{
                        System.out.println("Invalid input. Enter true or false.");
                    }

                }

                Task oldTask=new Task(name,isCompleted,date);
                taskList.removeTask(oldTask);
                choice=askToContinue(inputObject);
                if (choice){
                    input=getInput();
                }else{
                    System.out.println("Goodbye! Your tasks are safe and waiting to see you in the future.");
                    break;
                }

            } else if (input==3) {
                taskList.listTasks();
                choice=askToContinue(inputObject);
                if (choice){
                    input=getInput();
                }else{
                    System.out.println("Goodbye! Your tasks are safe and waiting to see you in the future.");
                    break;
                }

            } else if (input==4) {
                String name;
                System.out.print("Enter the title of the task to update: ");
                name=inputObject.nextLine();



                LocalDate date;
                while (true){
                    try{
                        System.out.print("Enter the due date of the task to update(YYYY-MM-DD): ");
                        String dateString=inputObject.nextLine();
                        date=LocalDate.parse(dateString);
                        break;
                    }catch(DateTimeParseException e){
                        System.out.println("Invalid input. Enter a date in the correct format.");
                    }
                }

                boolean isCompleted;
                while (true){
                    System.out.print("Enter if the task is completed or not(true/false): ");
                    String done= inputObject.nextLine();
                    if (done.toLowerCase().equals("true")){
                        isCompleted=true;
                        break;
                    } else if (done.toLowerCase().equals("false")) {
                        isCompleted=false;
                        break;
                    }else{
                        System.out.println("Invalid input. Enter true or false.");
                    }


                }


                if (isCompleted){
                    System.out.println("Task is already completed.");
                }else {
                    Task taskUpdate = new Task(name, isCompleted, date);
                    taskList.markCompleted(taskUpdate);
                }

                choice=askToContinue(inputObject);

                if (choice){
                    input=getInput();
                }else{
                    System.out.println("Goodbye! Your tasks are safe and waiting to see you in the future.");
                    break;
                }

            } else if (input==5) {
                taskList.listOverdue();
                choice=askToContinue(inputObject);
                if (choice){
                    input=getInput();
                }else{
                    System.out.println("Goodbye! Your tasks are safe and waiting to see you in the future.");
                    break;
                }
            } else{
                System.out.println("Incorrect choice.");
            }

        }
    }

    public static int getInput(){
        Scanner inputObject=new Scanner(System.in);
        System.out.println();
        System.out.println("1. Add Task");
        System.out.println("2. Remove TasK");
        System.out.println("3. List Tasks");
        System.out.println("4. Mark a Task as Completed");
        System.out.println("5. List Overdue Tasks");
        System.out.println();
        int input;
        while (true){
            try{
                System.out.print("Enter your choice again: ");
                input=inputObject.nextInt();
                inputObject.nextLine();
                break;
            } catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return input;
    }

    public static boolean askToContinue(Scanner scanner) {
        boolean input;
        while (true) {
            System.out.print("Do you want to continue(true/false)? ");
            String done = scanner.nextLine();
            if (done.toLowerCase().equals("true")) {
                input = true;
                break;
            } else if (done.toLowerCase().equals("false")) {
                input = false;
                break;
            } else {
                System.out.println("Invalid input. Enter true or false.");
            }
        }
        return input;
    }

}
