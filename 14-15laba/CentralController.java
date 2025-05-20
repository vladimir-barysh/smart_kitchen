import java.util.*;

class CentralController{
    private List<Device> devices;
    private ScheduleManager schedule;
    private Receipt receipt;
    private Stack<Task> executedTasks;

    public CentralController(Receipt receipt, ScheduleManager schedule) {
        this.devices = new ArrayList<>();
        this.receipt = receipt;
        this.schedule = schedule;
        this.executedTasks = new Stack<>();
    }

    public ScheduleInterface getSchedule(){
        return this.schedule;
    }

    public void addDevice(Device device) {
        if (device != null) {
            devices.add(device);
            receipt.addDevice(device);
            System.out.println("Следующее устройство добавлено в центральный контроллер: " + device.getType());
        }
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void executeSchedule(String currentTime) {
        System.out.println("Получение расписания на: " + currentTime);
        List<Task> tasks = schedule.getSchedule();
        List<Task> tasksToRemove = new ArrayList<>(); // Список задач для удаления
        for (Task task : tasks) {
            if (task.getTime().equals(currentTime)) {
                task.execute();
                executedTasks.push(task); // Сохраняем для отмены
                tasksToRemove.add(task); // Добавляем в список для удаления
            }
        }
        // Удаляем задачи после завершения цикла
        for (Task task : tasksToRemove) {
            schedule.releaseTask(task);
        }
    }

    // Метод для отмены последнего действия
    public void undoLastTask() {
        if (!executedTasks.isEmpty()) {
            Task lastTask = executedTasks.pop();
            lastTask.undo();
        } else {
            System.out.println("No tasks to undo");
        }
    }
    // Метод для использования посетителя
    public String acceptVisitor(Visitor visitor) {
        for (Device device : devices) {
            device.accept(visitor);
        }
        if (visitor instanceof ResourceCheckerVisitor) {
            return ((ResourceCheckerVisitor) visitor).getReport();
        }
        return "Visitor operation completed";
    }
}