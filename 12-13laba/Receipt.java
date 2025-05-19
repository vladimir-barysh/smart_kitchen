import java.util.HashMap;
import java.util.Map;

class Receipt {
    private Map<String, ProxyDevice> devices;

    public Receipt() {
        this.devices = new HashMap<>();
    }

    public void addDevice(ProxyDevice device) {
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

    public String makeCoffee(CentralController controller) {
        ProxyDevice coffeeMachine = devices.get("Кофемашина");
        if (coffeeMachine == null) {
            String result = "Ошибка: кофемашина недоступна";
            System.out.println(result);
            return result;
        }
        System.out.println("Получение алгоритма для приготовления кофе:");
        coffeeMachine.turnOn(controller);
        String result = coffeeMachine.makeCoffee(controller);
        coffeeMachine.turnOff(controller);
        return result;
    }
}