public class ProxyDevice implements Device {
    private Device realDevice;
    private DeviceChecker checker;

    public ProxyDevice(Device realDevice, DeviceChecker checker) {
        this.realDevice = realDevice;
        this.checker = checker;
    }

    public void turnOn() {
        System.out.println("[LOG] Turning on " + realDevice.getName());
        realDevice.turnOn();
    }

    public void turnOff() {
        System.out.println("[LOG] Turning off " + realDevice.getName());
        realDevice.turnOff();
    }

    public boolean getStatus() {
        return realDevice.getStatus();
    }

    public String getName() {
        return realDevice.getName();
    }

    public String checkStatus() {
        return checker.check(realDevice);
    }
}