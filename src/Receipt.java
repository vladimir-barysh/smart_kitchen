import java.util.HashMap;
import java.util.Map;

class Receipt {
    private Map<String, ProxyDevice> devices;

    public Receipt() {
        this.devices = new HashMap<>();
    }

    public void addDevice(ProxyDevice device) {
        String deviceType;
        switch (device.getDeviceType()) {
            case "CoffeeMachine":
                deviceType = "Кофемашина";
                break;
            case "Kettle":
                deviceType = "Чайник";
                break;
            case "Stove":
                deviceType = "Плита";
                break;
            case "Oven":
                deviceType = "Духовка";
                break;
            default:
                throw new IllegalArgumentException("Unknown device type: " + device.getDeviceType());
        }
        devices.put(deviceType, device);
        System.out.println("Device added to Receipt: " + deviceType);
    }

    public String makeCoffee() {
        ProxyDevice coffeeMachine = devices.get("Кофемашина");
        if (coffeeMachine == null) {
            String result = "Ошибка: кофемашина недоступна";
            System.out.println(result);
            return result;
        }
        System.out.println("Получение алгоритма для приготовления кофе:");
        coffeeMachine.turnOn();
        String result = coffeeMachine.makeCoffee();
        System.out.println(result);
        coffeeMachine.turnOff();
        return result;
    }

    public String boilWater() {
        ProxyDevice kettle = devices.get("Чайник");
        if (kettle == null) {
            String result = "Ошибка: чайник недоступен";
            System.out.println(result);
            return result;
        }
        System.out.println("Получение алгоритма для вскипячения воды:");
        kettle.turnOn();
        String result = kettle.boilWater();
        System.out.println(result);
        kettle.turnOff();
        return result;
    }

    public String heatStove(int temperature) {
        ProxyDevice stove = devices.get("Плита");
        if (stove == null) {
            String result = "Ошибка: плита недоступна";
            System.out.println(result);
            return result;
        }
        System.out.println("Получение алгоритма для нагрева плиты:");
        stove.turnOn();
        String result = stove.heatStove(temperature);
        System.out.println(result);
        stove.turnOff();
        return result;
    }

    public String heatOven(int temperature, int minutes) {
        ProxyDevice oven = devices.get("Духовка");
        if (oven == null) {
            String result = "Ошибка: духовка недоступна";
            System.out.println(result);
            return result;
        }
        System.out.println("Получение алгоритма для нагрева духовки:");
        oven.turnOn();
        String result = oven.heatOven(temperature, minutes);
        System.out.println(result);
        oven.turnOff();
        return result;
    }
}