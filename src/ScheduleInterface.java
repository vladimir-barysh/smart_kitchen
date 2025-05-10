import java.util.List;

// Интерфейс расписания
interface ScheduleInterface {
    void setSchedule(Task task);
    void updateSchedule(Task task);
    List<Task> getSchedule();
}