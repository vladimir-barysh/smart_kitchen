public class DeviceChecker {
    public String check(Device device) {
        if (!device.getStatus()) {
            return device.getName() + " is OFF, can't check.";
        }
        // Примерная логика: холодильник пустой
        if (device instanceof Fridge) {
            return device.getName() + ": Low on milk.";
        }
        return device.getName() + ": OK.";
    }
}