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
        // Добавляем задачу проверки продуктов каждый день в 20:00
        schedule.setSchedule(new Task("20:00", ActionConstants.CHECK_PRODUCTS));
    }

    public List<ProxyDevice> getDevices() {
        return devices;
    }

    public DeviceIterator getDeviceIterator() {
        return new DeviceListIterator(devices);
    }

    public void addDevice(ProxyDevice device) {
        if (device != null) {
            devices.add(device);
            receipt.addDevice(device);
            System.out.println("Следующее устройство было добавлено в центральный контроллер: " + device.getDeviceType());
        }
    }

    public void checkDevices() {
        System.out.println(checker.checkAvailability());
        DeviceIterator iterator = getDeviceIterator();
        while (iterator.hasNext()) {
            ProxyDevice device = iterator.next();
            System.out.println("Проверка устройства: " + device.getStatus());
        }
    }

    public void executeSchedule(String currentTime) {
        System.out.println("Проверка задач на: " + currentTime);
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