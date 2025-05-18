import org.w3c.dom.ls.LSOutput;

public class SmartKitchenFacade {
    private CentralController controller;
    private ScheduleInterface schedule;
    private Receipt receipt;
    private DeviceChecker checker;

    public SmartKitchenFacade() {
        this.receipt = new Receipt();
        this.schedule = new ScheduleManager();
        this.checker = new DeviceChecker();
        this.controller = new CentralController(receipt, schedule, checker);
        checker.setController(controller);
    }

    public void initializeSystem(Device... devices) {
        for (Device device : devices) {
            ProxyDevice proxy = new ProxyDevice(device);
            controller.addDevice(proxy);
        }
        System.out.println("Все устройства умной кухни готовы к использованию.");
    }

    public void setUpTask(String time, String action) {
        schedule.setSchedule(new Task(time, action));
    }

    public void setUpTaskStove(String time, String action, int temperature) {
        schedule.setSchedule(new Task(time, action, temperature));
    }

    public void setUpTaskOven(String time, String action, int temperature, int minutes) {
        schedule.setSchedule(new Task(time, action, temperature, minutes));
    }

    public void startAction(String currentTime) {
        System.out.println();
        controller.executeSchedule(currentTime);
    }

    public void checkSystemStatus() {
        controller.checkDevices();
        System.out.println("\nВнимание!!!");
        controller.sendAlert();
    }
}
