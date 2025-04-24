// Прокси для устройства
class ProxyDevice implements Device {
    private Device realDevice;
    private String cachedStatus;
    private String deviceType;

    public ProxyDevice(String deviceType) {
        this.deviceType = deviceType;
    }

    private void initializeDevice() {
        if (realDevice == null) {
            switch (deviceType) {
                case "Stove":
                    realDevice = new Stove();
                    break;
                case "CoffeeMachine":
                    realDevice = new CoffeeMachine();
                    break;
                case "Fridge":
                    realDevice = new Fridge();
                    break;
                case "Kettle":
                    realDevice = new Kettle();
                    break;
                case "Microwave":
                    realDevice = new Microwave();
                    break;
                case "Oven":
                    realDevice = new Oven();
                    break;
                // Добавить другие типы устройств
                default:
                    throw new IllegalArgumentException("Unknown device type");
            }
        }
    }

    @Override
    public String getStatus() {
        if (cachedStatus == null) {
            initializeDevice();
            cachedStatus = realDevice.getStatus();
        }
        return cachedStatus;
    }

    @Override
    public void turnOn() {
        initializeDevice();
        realDevice.turnOn();
        cachedStatus = realDevice.getStatus();
    }

    @Override
    public void turnOff() {
        initializeDevice();
        realDevice.turnOff();
        cachedStatus = realDevice.getStatus();
    }

    @Override
    public String makeCoffee() {
        initializeDevice();
        String result = realDevice.makeCoffee();
        cachedStatus = realDevice.getStatus();
        return result;
    }
}