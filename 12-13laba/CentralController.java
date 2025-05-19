import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CentralController implements Subject{
    private List<ProxyDevice> devices;
    private Checker checker;
    private ScheduleInterface schedule;
    private Receipt receipt;
    private Map<Device, List<CoffeeMachineMemento>> deviceHistory;
    private List<Observer> observers;

    public CentralController(Receipt receipt, ScheduleInterface schedule, Checker checker) {
        this.devices = new ArrayList<>();
        this.receipt = receipt;
        this.schedule = schedule;
        this.checker = checker;
        this.deviceHistory = new HashMap<>();
        this.observers = new ArrayList<>();
        addObserver(checker);
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObserver(Device device) {
        for (Observer observer : observers) {
            observer.update(device);
        }
    }

    public ScheduleInterface getSchedule(){
        return this.schedule;
    }

    public void addDevice(ProxyDevice device) {
        if (device != null) {
            devices.add(device);
            receipt.addDevice(device);
            deviceHistory.putIfAbsent(device, new ArrayList<>());
            System.out.println("Следующее устройство добавлено в центральный контроллер: " + device.getType());
        }
    }

    public List<ProxyDevice> getDevices() {
        return devices;
    }

    public void checkDevices() {
        System.out.println(checker.checkAvailability());
        DeviceIterator iterator = new DeviceListIterator(devices);
        while (iterator.hasNext()) {
            ProxyDevice device = iterator.next();
            System.out.println(device.getStatus());
        }

    }

    public void executeSchedule(String currentTime) {
        System.out.println("Получение расписания на: " + currentTime);
        List<Task> tasks = ((ScheduleManager) schedule).getSchedule();
        for (Task task : tasks) {
            if (task.getTime().equals(currentTime)) {
                task.execute(this, receipt);
            }
        }
    }

    public void sendAlert() {
        System.out.println(checker.reportStatus());
    }

    public void updateDeviceStatus(Device device) {
        System.out.println(" =" + device.getType() + ": обновлено состояние: " + device.getStatus());
        notifyObserver(device);
    }

    public void saveDeviceState(CoffeeMachine device) {
        if (!deviceHistory.containsKey(device)) {
            deviceHistory.put(device, new ArrayList<>());
        }
        CoffeeMachineMemento memento = device.createMemento();
        List<CoffeeMachineMemento> history = deviceHistory.get(device);
        if (history != null) {
            history.add(memento);
            System.out.println(" =" + device.getType() + ": сохранено состояние, количество сохраненных состояний: " + history.size());
        } else {
            System.out.println("Ошибка: история состояний недоступна для " + device.getType());
        }
    }

    public void restoreDeviceState(ProxyDevice device, int historyIndex) {
        List<CoffeeMachineMemento> history = deviceHistory.get(device.getRealDevice());
        if (history == null || historyIndex < 0 || historyIndex >= history.size()) {
            System.out.println("Невозможно вернуть состояние: неправильно указан индекс или у устройства отсутствует история.");
            return;
        }
        device.restoreMemento(history.get(historyIndex));
        // Удаляем последующие состояния после восстановления
        while (history.size() > historyIndex + 1) {
            history.remove(history.size() - 1);
        }
        notifyObserver(device);
    }
}