import java.util.*;

// Интерфейс для рецепта
class Receipt {
    private Map<String, ProxyDevice> devices;
    public Receipt() {
        this.devices = new HashMap<>();
    }
    public void addDevice(ProxyDevice device) {
        String deviceType;
        switch (device.getDeviceType()) {
            case "Плита":
                deviceType = "Плита";
                break;
            case "Кофемашина":
                deviceType = "Кофемашина";
                break;
            case "Чайник":
                deviceType = "Чайник";
                break;
            case "Духовка":
                deviceType = "Духовка";
                break;
            case "Холодильник":
                deviceType = "Холодильник";
                break;
            default:
                throw new IllegalArgumentException("Unknown device type");
        }
        devices.put(deviceType, device);
    }
    public String makeCoffee() {
        ProxyDevice coffeeMachine = devices.get("Кофемашина");
        if (coffeeMachine == null) {
            String result = "Ошибка: кофемашина недоступна";
            System.out.println(result);
            return result;
        }
        System.out.println("//Получение алгоритма для приготовления кофе...//");
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
        System.out.println("//Получение алгоритма для вскипячения воды...//");
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
        if (temperature == 0){
            stove.turnOff();
            return "0";
        }
        System.out.println("//Получение алгоритма для разогрева плиты...//");
        stove.turnOn();
        String result = stove.heatStove(temperature);
        System.out.println(result);
        return result;
    }
    public String heatOven(int timeMin, int temperature){
        ProxyDevice oven = devices.get("Духовка");
        if(oven == null){
            String result = "Ошибка: духовка недоступна";
            System.out.println(result);
            return result;
        }
        System.out.println("//Получение алгоритма для включения духовки...//");
        oven.turnOn();
        String result = oven.heatOven(timeMin, temperature);
        System.out.println(result);
        oven.turnOff();
        return result;
    }
}