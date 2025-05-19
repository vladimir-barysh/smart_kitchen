import java.util.List;
import java.util.Map;

// Интерфейс расписания
interface ScheduleInterface {
    void setSchedule(Task task);
    List<Task> getSchedule();
}