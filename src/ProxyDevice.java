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
                case "Плита":
                    realDevice = new Stove();
                    break;
                case "Кофемашина":
                    realDevice = new CoffeeMachine();
                    break;
                case "Холодильник":
                    realDevice = new Fridge();
                    break;
                case "Чайник":
                    realDevice = new Kettle();
                    break;
                case "Духовка":
                    realDevice = new Oven();
                    break;
                // Добавить другие типы устройств
                default:
                    throw new IllegalArgumentException("Unknown device type");
            }
        }
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
    public String getStatus() {
        if (cachedStatus == null) {
            initializeDevice();
            cachedStatus = realDevice.getStatus();
        }
        return cachedStatus;
    }

    @Override
    public String getDeviceType(){
        return deviceType;
    }
    @Override
    public String makeCoffee() {
        initializeDevice();
        String result = realDevice.makeCoffee();
        cachedStatus = realDevice.getStatus();
        return result;
    }
    @Override
    public String boilWater(){
        initializeDevice();
        String result = realDevice.boilWater();
        cachedStatus = realDevice.getStatus();
        return result;
    }
    @Override
    public String heatStove(int temperature) {
        initializeDevice();
        String result = realDevice.heatStove(temperature);
        cachedStatus = realDevice.getStatus();
        return result;
    }
    @Override
    public String heatOven(int timeMin, int temperature){
        initializeDevice();
        String result = realDevice.heatOven(timeMin, temperature);
        cachedStatus = realDevice.getStatus();
        return result;
    }
}