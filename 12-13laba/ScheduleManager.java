import java.util.ArrayList;
import java.util.List;

class ScheduleManager implements ScheduleInterface {
    private List<Task> tasks;

    public ScheduleManager() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void setSchedule(Task task) {
        tasks.add(task);
        System.out.println("Получена задача: " + task.getAction() + " в " + task.getTime());
    }

    @Override
    public List<Task> getSchedule() {
        return tasks;
    }

}