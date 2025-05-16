class LoggingDeviceDecorator implements Device {
    private Device device;

    public LoggingDeviceDecorator(Device device) {
        this.device = device;
    }
    public Device getDevice(){
        return this.device;
    }

    @Override
    public String getStatus() {
        String status = device.getStatus();
        System.out.println("Logging status retrieval for device: " + status);
        return status;
    }

    @Override
    public void turnOn() {
        System.out.println("Logging turnOn for device");
        device.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Logging turnOff for device");
        device.turnOff();
    }

    @Override
    public String makeCoffee() {
        System.out.println("Logging makeCoffee operation");
        return device.makeCoffee();
    }

    @Override
    public String boilWater() {
        System.out.println("Logging boilWater operation");
        return device.boilWater();
    }

    @Override
    public String heatStove(int temperature) {
        System.out.println("Logging heatStove operation at " + temperature + "C");
        return device.heatStove(temperature);
    }

    @Override
    public String heatOven(int temperature, int minutes) {
        System.out.println("Logging heatOven operation at " + temperature + "C for " + minutes + " minutes");
        return device.heatOven(temperature, minutes);
    }

    @Override
    public String checkProducts() {
        System.out.println("Logging checkProducts operation");
        return device.checkProducts();
    }
}
