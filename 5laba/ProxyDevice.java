class ProxyDevice implements Device {
    private Device realDevice;
    private String cachedStatus;

    public ProxyDevice(Device realDevice) {
        this.realDevice = realDevice;
    }

    public LoggingDecorator getLoggingDecorator() {
        Device current = realDevice;
        while (current instanceof ProxyDevice) current = ((ProxyDevice) current).realDevice;
        return (current instanceof LoggingDecorator) ? (LoggingDecorator) current : null;
    }

    @Override
    public String getType() {
        return realDevice.getType();
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
