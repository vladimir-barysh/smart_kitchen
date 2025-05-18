import java.util.List;
import java.util.Map;

// Интерфейс расписания
interface ScheduleInterface {
    void setSchedule(Task task);
    void setRoutine(String startTime, ActionComposite routine);
    List<Task> getSchedule();
    Map<String, ActionComposite> getRoutines();
}