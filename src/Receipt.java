import java.util.HashMap;
import java.util.Map;

class Receipt {
    private Map<String, ProxyDevice> devices;

    public Receipt() {
        this.devices = new HashMap<>();
    }

    public void addDevice(ProxyDevice device) {
        switch (device.getDeviceType()) {
            case "ModernCoffeeMachine":
            case "CoffeeMachine":
                devices.put("Кофемашина", device);
                break;
            case "Kettle":
                devices.put("Чайник", device);
                break;
            case "Stove":
                devices.put("Плита", device);
                break;
            case "Oven":
                devices.put("Духовка", device);
                break;
            case "Fridge":
                devices.put("Холодильник", device);
                break;
            default:
                throw new IllegalArgumentException("Unknown device type: " + device.getDeviceType());
        }
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

    public String checkProducts() {
        ProxyDevice fridge = devices.get("Холодильник");
        if (fridge == null) {
            String result = "Ошибка: холодильник недоступен";
            System.out.println(result);
            return result;
        }
        System.out.println("Проверка содержимого холодильника:");
        String result = fridge.checkProducts();
        System.out.println(result);
        return result;
    }
}