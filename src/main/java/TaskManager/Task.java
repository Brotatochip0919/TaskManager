package TaskManager;

public class Task {

    public String title;
    public String description;
    public String progress;
    public String due_date;

    public Task() {
        title = "";
        description = "";
        progress = "";
        due_date = "";
    }

    public Task(String name, String desc, String prog, String due) {
        title = name;
        description = desc;
        progress = prog;
        due_date = due;
    }

    @Override
    public String toString() {
        return (title + ": " + progress + "  -- " + due_date);
    }

}
