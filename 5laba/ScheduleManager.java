import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ScheduleManager implements ScheduleInterface {
    private List<Task> tasks;
    private Map<String, ActionComposite> routines;

    public ScheduleManager() {
        tasks = new ArrayList<>();
        routines = new HashMap<>();
    }

    @Override
    public void setSchedule(Task task) {
        tasks.add(task);
        System.out.println("Получена задача: " + task.getAction() + " в " + task.getTime());
    }

    public void setRoutine(String startTime, ActionComposite routine) {
        routines.put(startTime, routine);
        System.out.println("Добавлен алгоритм: " + routine.getName() + ", начало в " + startTime);
    }

    @Override
    public List<Task> getSchedule() {
        return tasks;
    }

    @Override
    public Map<String, ActionComposite> getRoutines() {
        return routines;
    }
}