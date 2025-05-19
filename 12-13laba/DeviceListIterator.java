import java.util.List;

class DeviceListIterator implements DeviceIterator {
    private List<ProxyDevice> devices;
    private int currentIndex = 0;

    public DeviceListIterator(List<ProxyDevice> devices) {
        this.devices = devices;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < devices.size();
    }

    @Override
    public ProxyDevice next() {
        if (!hasNext()) return null;
        return devices.get(currentIndex++);
    }
}