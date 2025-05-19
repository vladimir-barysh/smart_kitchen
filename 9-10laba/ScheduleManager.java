import java.util.ArrayList;
import java.util.List;

class ScheduleManager implements ScheduleInterface {
    private List<Task> tasks;
    private TaskPool taskPool;

    public ScheduleManager(TaskPool taskPool) {
        this.tasks = new ArrayList<>();
        this.taskPool = taskPool;
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

    public void releaseTask(Task task) {
        taskPool.releaseTask(task);
    }
}