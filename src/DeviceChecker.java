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
        if (controller == null) {
            String report = "Ошибка: контроллер не установлен";
            System.out.println(report);
            return report;
        }
        List<String> issues = new ArrayList<>();
        for (ProxyDevice device : controller.getDevices()) {
            String status = device.getStatus();
            if (status.contains("Кофемашина")) {
                int water = parseValue(status, "воды - ", "мл");
                int coffee = parseValue(status, "кофе - ", "г");
                if (water < 100) issues.add("Кофемашина: недостаточно воды");
                if (coffee < 10) issues.add("Кофемашина: недостаточно кофе");
            } else if (status.contains("Чайник")) {
                int water = parseValue(status, "воды - ", "мл");
                if (water < 200) issues.add("Чайник: недостаточно воды");
            } else if (status.contains("Холодильник")) {
                int milk = parseValue(status, "молока - ", "мл");
                int eggs = parseValue(status, "яиц - ", "шт");
                if (milk < 200) issues.add("Холодильник: мало молока");
                if (eggs < 2) issues.add("Холодильник: мало яиц");
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
}