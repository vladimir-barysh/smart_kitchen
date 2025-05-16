// Адаптер для нового устройства
class ModernDeviceAdapter implements Device {
    private ModernDevice modernDevice;

    public ModernDeviceAdapter(ModernDevice modernDevice) {
        this.modernDevice = modernDevice;
    }

    public ModernDevice getModernDevice(){
        return this.modernDevice;
    }

    @Override
    public String getStatus() {
        return modernDevice.getCurrentState();
    }

    @Override
    public void turnOn() {
        modernDevice.powerOn();
    }

    @Override
    public void turnOff() {
        modernDevice.powerOff();
    }

    @Override
    public String makeCoffee() {
        return modernDevice.brewCoffee();
    }
}