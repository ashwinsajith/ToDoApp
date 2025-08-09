import java.time.LocalDate;

public class Task {
    private String title;
    private boolean isDone;
    private LocalDate dueDate;

    public Task(String title, boolean isDone, LocalDate dueDate){
        this.title=title;
        this.isDone=isDone;
        this.dueDate=dueDate;
    }

    public void markCompleted(){
        this.isDone=true;
    }

    @Override
    public String toString(){
        String stringFormat;
        if (isDone==true) {
            stringFormat = "Task: " + title + "| Due on: " + dueDate + "| Completed: Yes";
        }else{
            stringFormat = "Task: " + title + "| Due on: " + dueDate + "| Completed: No";
        }
        return stringFormat;
    }

    public String getTitle(){
        return this.title;
    }

    public LocalDate getDueDate(){
        return this.dueDate;
    }

    public boolean isCompleted(){
        return this.isDone;
    }

    public boolean isOverdue(){
        if (LocalDate.now().isAfter(dueDate)){
            return true;
        }else return false;
    }

    @Override
    public boolean equals(Object obj){

        if (this==obj) return true;
        if (obj==null || getClass()!= obj.getClass()) return false;

        Task task2=(Task) obj;
        return (this.title.equals(task2.getTitle()) && this.dueDate.equals(task2.getDueDate()) && this.isDone==task2.isCompleted());

    }

}
