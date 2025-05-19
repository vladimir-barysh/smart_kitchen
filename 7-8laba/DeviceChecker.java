import java.util.ArrayList;
import java.util.List;

class DeviceChecker implements Checker {
    private CentralController controller;

    public DeviceChecker() {
        // Пустой конструктор
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
        if (controller == null) { String report = "Ошибка: контроллер не установлен"; System.out.println(report); return report; }
        List<String> issues = new ArrayList<>();
        for (ProxyDevice device : controller.getDevices()) {
            issues.addAll(device.reportIssues()); // Устройства сами сообщают о проблемах
        }
        String report = issues.isEmpty() ? "Все компоненты в норме" : String.join("\n", issues);
        return report;
    }
}