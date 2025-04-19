public class Main {
    public static void main(String[] args) {
        DeviceChecker checker = new DeviceChecker();

        ProxyDevice fridge = new ProxyDevice(new Fridge(), checker);
        fridge.turnOn();

        CentralController controller = new CentralController();
        controller.addDevice(fridge);
//
        controller.runChecks();
    }
}