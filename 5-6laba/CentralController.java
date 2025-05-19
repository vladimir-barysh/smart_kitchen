import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            }
        }
        Map<String, ActionComposite> routines = ((ScheduleManager) schedule).getRoutines();
        for (Map.Entry<String, ActionComposite> entry : routines.entrySet()) {
            if (entry.getKey().equals(currentTime)) {
                entry.getValue().execute(receipt);
            }
        }
    }

    public void sendAlert() {
        System.out.println(checker.reportStatus());
    }

    public void getAllActionLogs() {
        for (ProxyDevice device : devices) {
            LoggingDecorator decorator = device.getLoggingDecorator();
            if (decorator != null) {
                System.out.println(device.getType());
                for (String log : decorator.getLog()) {
                    System.out.println("  - " + log);
                }
            }
        }
    }
}