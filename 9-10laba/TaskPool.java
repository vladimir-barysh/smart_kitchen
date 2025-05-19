import java.util.ArrayList;
import java.util.List;

class TaskPool {
    private List<Task> pool;
    private final int maxSize;
    private int createdTasks = 0;

    public TaskPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new ArrayList<>();
        // Инициализируем пул
        for (int i = 0; i < maxSize; i++) {
            pool.add(new Task("", ""));
            createdTasks++;
        }
    }

    public Task acquireTask(String time, String action) {
        return acquireTask(time, action, 0, 0);
    }

    public Task acquireTask(String time, String action, int temperature) {
        return acquireTask(time, action, temperature, 0);
    }

    public Task acquireTask(String time, String action, int temperature, int minutes) {
        // Ищем свободную задачу в пуле
        for (Task task : pool) {
            if (!task.isInUse()) {
                task.setValues(time, action, temperature, minutes);
                task.setInUse(true);
                System.out.println("Задача добавлена в пул: " + task);
                return task;
            }
        }
        // Если свободных задач нет и пул не достиг максимального размера, создаём новую
        if (createdTasks < maxSize) {
            Task newTask = new Task(time, action, temperature, minutes);
            newTask.setInUse(true);
            pool.add(newTask);
            createdTasks++;
            System.out.println("Новая задача создана и получена: " + newTask);
            return newTask;
        }
        throw new IllegalStateException("Пул задач полон");
    }

    public void releaseTask(Task task) {
        if (pool.contains(task)) {
            task.setInUse(false);
            System.out.println("Задача убрана из пула: " + task);
        } else {
            throw new IllegalArgumentException("Задача не принадлежит пулу");
        }
    }
}