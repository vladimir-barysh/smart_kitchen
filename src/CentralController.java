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
            System.out.println("Device added to CentralController: " + device.getDeviceType());
        }
    }

    public void checkDevices() {
        for (ProxyDevice device : devices) {
            System.out.println(device.getStatus());
        }
        System.out.println(checker.checkAvailability());
    }

    public void executeSchedule(String currentTime) {
        System.out.println("Checking schedule for time: " + currentTime);
        List<Task> tasks = ((ScheduleManager) schedule).getSchedule();
        for (Task task : tasks) {
            if (task.getTime().equals(currentTime)) {
                task.execute(receipt);
            }
        }
        checkDevices();
    }

    public void sendAlert() {
        System.out.println("Alert: " + checker.reportStatus());
    }
}