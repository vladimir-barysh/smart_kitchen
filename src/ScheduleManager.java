import java.util.ArrayList;
import java.util.List;

class ScheduleManager implements ScheduleInterface {
    private List<Task> tasks;

    public ScheduleManager() {
        tasks = new ArrayList<>();
    }

    @Override
    public void setSchedule(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getAction() + " at " + task.getTime());
    }

    @Override
    public void updateSchedule(Task task) {
        tasks.removeIf(t -> t.getAction().equals(task.getAction()));
        tasks.add(task);
        System.out.println("Task updated: " + task.getAction() + " at " + task.getTime());
    }

    @Override
    public List<Task> getSchedule() {
        return tasks;
    }
}