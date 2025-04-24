import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Центральный контроллер
class CentralController {
    private List<ProxyDevice> devices;
    private Checker checker;
    private ScheduleInterface schedule;

    public CentralController() {
        devices = new ArrayList<>();
        checker = new DeviceChecker(this);
        schedule = new ScheduleManager();
    }

    public void addDevice(ProxyDevice device) {
        devices.add(device);
    }

    public List<ProxyDevice> getDevices() {
        return devices;
    }

    public void checkDevices() {
        System.out.println(checker.checkAvailability());
        for (ProxyDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }

    public void addSchedule(ScheduleInterface schedule){
        this.schedule = schedule;
    }

    public void executeSchedule() {
        System.out.println("Получение расписания: " + schedule.getSchedule());
    }

    public void sendAlert() {
        if (!Objects.equals(checker.reportStatus(devices), "0")){
            System.out.println("ВНИМАНИЕ!!!\n" + checker.reportStatus(devices));
        }

    }

    public String makeCoffee(String deviceType) {
        for (ProxyDevice device : devices) {
            if (device.getStatus().contains(deviceType)) {
                return device.makeCoffee();
            }
        }
        return "Ошибка: кофемашина не найдена.";
    }
}