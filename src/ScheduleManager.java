import java.util.ArrayList;
import java.util.List;

// Реализация менеджера расписания
class ScheduleManager implements ScheduleInterface {
    private String schedule;
    private List<Task> tasks;

    public ScheduleManager() {
        tasks = new ArrayList<>();
    }

    @Override
    public void setSchedule(Task task) {
        tasks.add(task);
        System.out.println("Добавлена задача: " + task.getAction() + " в " + task.getTime());
    }

    @Override
    public void updateSchedule(Task task) {
        tasks.removeIf(t -> t.getAction().equals(task.getAction()));
        tasks.add(task);
        System.out.println("Добавлена: " + task.getAction() + " задача " + task.getTime());
    }

    @Override
    public List<Task> getSchedule() {
        return tasks;
    }
}