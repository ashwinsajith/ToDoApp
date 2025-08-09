import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks;

    public ToDoList(){
        this.tasks=new ArrayList<>();
    }

    public void addTask(Task task){
        tasks.add(task);
        System.out.println("✅ Task added successfully: "+task.getTitle());
    }

    public void removeTask(Task task){
        for (int i=0;i<tasks.size();i++){
            if (tasks.get(i).equals(task)){
                tasks.remove(i);
                i--;
            }
        }
        System.out.println("✅ Task removed successfully: "+task.getTitle());
    }

    public void listTasks(){
        for(int i=0;i<tasks.size();i++){
            if (tasks.get(i).isCompleted()) {
                System.out.println((i + 1) + ". " + "[✔] " + tasks.get(i).getTitle() + " | " + "Due: " + tasks.get(i).getDueDate());
            }else {
                System.out.println((i + 1) + ". " + "[ ] " + tasks.get(i).getTitle() + " | " + "Due: " + tasks.get(i).getDueDate());
            }
        }
    }

    public void markCompleted(Task task){
        for (int i=0;i<tasks.size();i++){
            if (tasks.get(i).equals(task)){
                tasks.get(i).markCompleted();
            }
        }
        System.out.println("Task updated!");
    }

    public void listOverdue(){
        System.out.println("Overdue Tasks:");
        int count=0;
        for (Task task:this.tasks){
            if (task.isOverdue()){
                System.out.println(task.toString());
                count++;
            }
        }
        if (count==0){
            System.out.println("No overdue tasks at all! Great job staying on top.");
        }

    }

}
