import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class CentralController {
    private static CentralController instance;
    private List<ProxyDevice> devices;
    private Checker checker;
    private ScheduleInterface schedule;
    private Receipt receipt;

    public CentralController(TaskPool taskPool) {
        this.devices = new ArrayList<>();
        this.receipt = new Receipt();
        this.schedule = new ScheduleManager(taskPool);
        this.checker = new DeviceChecker();
    }

    public static CentralController getInstance(TaskPool taskPool) {
        if (instance == null) {
            instance = new CentralController(taskPool);
        }
        return instance;
    }

    public static CentralController getInstance() { // Для обратной совместимости
        if (instance == null) {
            throw new IllegalStateException("CentralController must be initialized with a TaskPool");
        }
        return instance;
    }

    public ScheduleInterface getSchedule(){
        return this.schedule;
    }

    public void addDevice(ProxyDevice device) {
        if (device != null) {
            devices.add(device);
            receipt.addDevice(device);
            System.out.println("Следующее устройство добавлено в центральный контроллер: " + device.getType());
        }
    }

    public List<ProxyDevice> getDevices() {
        return devices;
    }

    public void checkDevices() {
        System.out.println(checker.checkAvailability());
        DeviceIterator iterator = new DeviceListIterator(devices);
        while (iterator.hasNext()) {
            ProxyDevice device = iterator.next();
            System.out.println(device.getStatus());
        }

    }

    public void executeSchedule(String currentTime) {
        System.out.println("Получение расписания на: " + currentTime);
        List<Task> tasks = ((ScheduleManager) schedule).getSchedule();
        for (Task task : tasks) {
            if (task.getTime().equals(currentTime)) {
                task.execute(receipt);
                ((ScheduleManager) schedule).releaseTask(task);
            }
        }
    }

    public void sendAlert() {
        System.out.println(checker.reportStatus());
    }
}