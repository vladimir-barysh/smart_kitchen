import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Центральный контроллер
class CentralController {
    private List<ProxyDevice> devices;
    private Receipt receipt;
    private Checker checker;
    private ScheduleInterface schedule;

    public CentralController() {
        devices = new ArrayList<>();
        checker = new DeviceChecker(this);
        schedule = new ScheduleManager();
        receipt = new Receipt();
    }

    public void addDevice(ProxyDevice device) {
        if (device != null) {
            devices.add(device);
            receipt.addDevice(device); // Гарантируем синхронизацию
            System.out.println("//Следующее устройство было добавлено в систему: " + device.getDeviceType()+"//");
        }
    }
    public List<ProxyDevice> getDevices(){
        return devices;
    }

    public void checkDevices() {
        System.out.println(checker.checkAvailability());
        for (ProxyDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }

    public void setSchedule(ScheduleInterface schedule) {
        this.schedule = schedule;
        System.out.println("//Расписание сохранено//");
    }

    public void executeSchedule(String currentTime) {
        System.out.println("//Проверка соответствующего расписания на: " + currentTime + " //");
        List<Task> tasks = ((ScheduleManager) schedule).getSchedule();
        for (Task task : tasks) {
            if (task.getTime().equals(currentTime)) {
                task.execute(receipt);
            }
        }
    }

    public void sendAlert() {
        String result = new String(checker.reportStatus());
        if (!Objects.equals(result, "Все компоненты в норме")){
            System.out.println("ВНИМАНИЕ!!!\n" + result);
        }
        else {
            System.out.println(result);
        }
    }
}