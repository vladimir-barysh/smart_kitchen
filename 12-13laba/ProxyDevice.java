import java.util.List;

class ProxyDevice implements Device {
    private Device realDevice;
    private String cachedStatus;

    public ProxyDevice(Device realDevice) {
        this.realDevice = realDevice;
    }

    public CoffeeMachineMemento createMemento() {
        return realDevice.createMemento();
    }

    public void restoreMemento(CoffeeMachineMemento memento) {
        realDevice.restoreMemento(memento);
        cachedStatus = null;
    }

    public Device getRealDevice(){
        return this.realDevice;
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
    public void turnOn(CentralController controller) {
        realDevice.turnOn(controller);
        cachedStatus = null;
    }

    @Override
    public void turnOff(CentralController controller) {
        realDevice.turnOff(controller);
        cachedStatus = null;
    }

    @Override
    public String makeCoffee(CentralController controller) {
        String result = realDevice.makeCoffee(controller);
        cachedStatus = null;
        return result;
    }
}
