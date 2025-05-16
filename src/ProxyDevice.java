class ProxyDevice implements Device {
    private Device realDevice;
    private String cachedStatus;

    public ProxyDevice(LoggingDeviceDecorator logDec) {
        this.realDevice = logDec.getDevice();
    }

    public String getDeviceType() {
        Device current = realDevice;
        while (current instanceof LoggingDeviceDecorator || current instanceof ModernDeviceAdapter) {
            if (current instanceof LoggingDeviceDecorator) {
                current = ((LoggingDeviceDecorator) current).getDevice();
            } else if (current instanceof ModernDeviceAdapter) {
                ModernDevice modernDev = ((ModernDeviceAdapter) current).getModernDevice();
                if (modernDev instanceof ModernCoffeeMachine) {
                    return "ModernCoffeeMachine";
                }
                // Добавлять другие устройства
                current = (Device) modernDev;
            }

        if (current instanceof CoffeeMachine) return "CoffeeMachine";
        if (current instanceof Kettle) return "Kettle";
        if (current instanceof Stove) return "Stove";
        if (current instanceof Oven) return "Oven";
        if (current instanceof Fridge) return "Fridge";
        return current.getClass().getSimpleName();
    }

    @Override
    public String getStatus() {
        if (cachedStatus == null) {
            cachedStatus = realDevice.getStatus();
        }
        return cachedStatus;
    }

    @Override
    public void turnOn() {
        realDevice.turnOn();
        cachedStatus = realDevice.getStatus();
    }

    @Override
    public void turnOff() {
        realDevice.turnOff();
        cachedStatus = realDevice.getStatus();
    }

    @Override
    public String makeCoffee() {
        String result = realDevice.makeCoffee();
        cachedStatus = realDevice.getStatus();
        return result;
    }

    @Override
    public String boilWater() {
        String result = realDevice.boilWater();
        cachedStatus = realDevice.getStatus();
        return result;
    }

    @Override
    public String heatStove(int temperature) {
        String result = realDevice.heatStove(temperature);
        cachedStatus = realDevice.getStatus();
        return result;
    }

    @Override
    public String heatOven(int temperature, int minutes) {
        String result = realDevice.heatOven(temperature, minutes);
        cachedStatus = realDevice.getStatus();
        return result;
    }

    @Override
    public String checkProducts() {
        String result = realDevice.checkProducts();
        cachedStatus = realDevice.getStatus();
        return result;
    }
}
