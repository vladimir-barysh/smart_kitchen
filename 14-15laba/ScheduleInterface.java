import java.util.List;

// Интерфейс расписания
interface ScheduleInterface {
    void setSchedule(Task task);
    List<Task> getSchedule();
    void releaseTask( Task task);
}