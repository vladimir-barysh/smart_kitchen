import java.util.HashMap;
import java.util.Map;

// Фабрика Flyweight для управления общими объектами TaskType
class TaskTypeFactory {
    private static final Map<String, TaskType> taskTypes = new HashMap<>();

    public static TaskType getTaskType(String action) {
        return taskTypes.computeIfAbsent(action, a -> {
            System.out.println("Creating new TaskType for action: " + a);
            return new TaskType(a);
        });
    }

    public static int getTaskTypeCount() { return taskTypes.size(); }
}
