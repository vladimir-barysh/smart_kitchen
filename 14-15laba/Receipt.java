import java.util.HashMap;
import java.util.Map;

class Receipt {
    private Map<String, Device> devices;

    public Receipt() {
        this.devices = new HashMap<>();
    }

    public void addDevice(Device device) {
        String deviceType;
        switch (device.getType()) {
            case "CoffeeMachine":
                deviceType = "Кофемашина";
                break;
            default:
                throw new IllegalArgumentException("Unknown device type: " + device.getType());
        }
        devices.put(deviceType, device);
    }

    public String makeCoffee() {
        Device coffeeMachine = devices.get("Кофемашина");
        if (coffeeMachine == null) {
            String result = "Ошибка: кофемашина недоступна";
            System.out.println(result);
            return result;
        }
        System.out.println("Получение алгоритма для приготовления кофе:");
        coffeeMachine.turnOn();
        String result = coffeeMachine.makeCoffee();
        coffeeMachine.turnOff();
        return result;
    }
}