import java.util.ArrayList;
import java.util.List;

class CentralController {
    private List<ProxyDevice> devices;
    private Checker checker;
    private ScheduleInterface schedule;
    private Receipt receipt;

    public CentralController(Receipt receipt, ScheduleInterface schedule, Checker checker) {
        this.devices = new ArrayList<>();
        this.receipt = receipt;
        this.schedule = schedule;
        this.checker = checker;
    }

    public List<ProxyDevice> getDevices() {
        return devices;
    }

    public void addDevice(ProxyDevice device) {
        if (device != null) {
            devices.add(device);
            receipt.addDevice(device);
            System.out.println("Следующее устройство добавлено в центральный контроллер: " + device.getType());
        }
    }

    public void checkDevices() {
        System.out.println(checker.checkAvailability());
        for (ProxyDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }

    public void executeSchedule(String currentTime) {
        System.out.println("Получение расписания на: " + currentTime);
        List<Task> tasks = ((ScheduleManager) schedule).getSchedule();
        for (Task task : tasks) {
            if (task.getTime().equals(currentTime)) {
                task.execute(receipt);
            }
        }
    }

    public void sendAlert() {
        System.out.println(checker.reportStatus());
    }
}