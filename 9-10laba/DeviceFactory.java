// Новый класс Factory Method
abstract class DeviceFactory {
    public abstract ProxyDevice createDevice();

}

class CoffeeMachineFactory extends DeviceFactory {
    @Override
    public ProxyDevice createDevice() {
        System.out.println("Кофемашина создана с помощью фабричного метода");
        return new ProxyDevice(new CoffeeMachine());
    }
}

class FridgeFactory extends DeviceFactory {
    @Override
    public ProxyDevice createDevice() {
        System.out.println("Холодильник создан с помощью фабричного метода");
        return new ProxyDevice(new Fridge());
    }
}

class KettleFactory extends DeviceFactory {
    @Override
    public ProxyDevice createDevice() {
        System.out.println("Чайник создан с помощью фабричного метода");
        return new ProxyDevice(new Kettle());
    }
}

class OvenFactory extends DeviceFactory {
    @Override
    public ProxyDevice createDevice() {
        System.out.println("Духовка создана с помощью фабричного метода");
        return new ProxyDevice(new Oven());
    }
}

class StoveFactory extends DeviceFactory {
    @Override
    public ProxyDevice createDevice() {
        System.out.println("Плита создана с помощью фабричного метода");
        return new ProxyDevice(new Stove());
    }
}