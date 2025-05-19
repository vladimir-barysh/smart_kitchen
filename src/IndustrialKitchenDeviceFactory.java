public class IndustrialKitchenDeviceFactory implements KitchenDeviceFactory {
    public ProxyDevice createCoffeeMachine() {
        System.out.println("Создана промышленная кофемашина");
        return new ProxyDevice(new IndustrialCoffeeMachine());
    }
    public ProxyDevice createFridge() {
        System.out.println("Создан промышленный холодильник");
        return new ProxyDevice(new IndustrialFridge());
    }
    public ProxyDevice createKettle() {
        System.out.println("Создан промышленный чайник");
        return new ProxyDevice(new IndustrialKettle());
    }
    public ProxyDevice createStove() {
        System.out.println("Создана промышленная плита");
        return new ProxyDevice(new IndustrialStove());
    }
    public ProxyDevice createOven() {
        System.out.println("Создана промышленная духовка");
        return new ProxyDevice(new IndustrialOven());
    }

}
