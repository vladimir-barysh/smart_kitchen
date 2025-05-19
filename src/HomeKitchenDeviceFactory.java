class HomeKitchenDeviceFactory implements KitchenDeviceFactory {
    public ProxyDevice createCoffeeMachine() {
        System.out.println("Создана домашняя кофемашина");
        return new ProxyDevice(new CoffeeMachine());
    }
    public ProxyDevice createFridge() {
        System.out.println("Создан домашний холодильник");
        return new ProxyDevice(new Fridge());
    }
    public ProxyDevice createKettle() {
        System.out.println("Создан домашний чайник");
        return new ProxyDevice(new Kettle());
    }
    public ProxyDevice createStove() {
        System.out.println("Создана домашняя плита");
        return new ProxyDevice(new Stove());
    }
    public ProxyDevice createOven() {
        System.out.println("Создана домашняя духовка");
        return new ProxyDevice(new Oven());
    }

}