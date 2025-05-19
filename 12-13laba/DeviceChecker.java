import java.util.ArrayList;
import java.util.List;

class DeviceChecker implements Checker {
    private CentralController controller;
    private List<Device> devices;

    public DeviceChecker() {
        this.devices = new ArrayList<>();
    }

    public void setController(CentralController controller) {
        this.controller = controller;
    }

    @Override
    public String checkAvailability() {
        if (controller == null) return "Ошибка: контроллер не установлен";
        return "Проверка доступности компонентов...";
    }

    @Override
    public String reportStatus() {
        if (controller == null) {
            String report = "Ошибка: контроллер не установлен";
            System.out.println(report);
            return report;
        }
        List<String> issues = new ArrayList<>();
        for (Device device : controller.getDevices()) {
            String type = device.getType();
            String status = device.getStatus();
            int idDash = status.indexOf(" - ");
            String name = status.substring(0, idDash).trim();
            if (type == "CoffeeMachine") {
                int water = parseValue(status, "воды - ", "мл");
                int coffee = parseValue(status, "кофе - ", "г");
                if (water < 100) issues.add(name + ": недостаточно воды");
                if (coffee < 10) issues.add(name + ": недостаточно кофе");
            }
        }
        String report = issues.isEmpty() ? "Все компоненты в норме" : String.join("\n", issues);
        return report;
    }

    private int parseValue(String status, String prefix, String suffix) {
        try {
            return Integer.parseInt(status.split(prefix)[1].split(suffix)[0]);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void update(Device device) {
        // При обновлении добавляем устройство в список, если его там нет
        if (!devices.contains(device)) {
            devices.add(device);
        }
        System.out.println(" !!! Уведомление об изменении состояния устройства: " + device.getType() + " !!!");
        reportStatus();
    }
}