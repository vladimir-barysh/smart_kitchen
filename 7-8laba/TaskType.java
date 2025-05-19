// Flyweight для хранения внутреннего состояния задачи (action и deviceType)
public class TaskType {
    private final String action;

    public TaskType(String action) {
        this.action = action;
    }

    public String getAction() { return action; }
}
