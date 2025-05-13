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
        return "Проверка доступности компонентов...";
    }

    @Override
    public String reportStatus() {
        List<String> issues = new ArrayList<>();
        for (ProxyDevice device : controller.getDevices()) {
            String status = device.getStatus();
            if (status.contains("CoffeeMachine")) {
                int water = parseValue(status, "Water: ", "ml");
                int coffee = parseValue(status, "Coffee: ", "g");
                if (water < 100) issues.add("Кофемашина: недостаточно воды");
                if (coffee < 10) issues.add("Кофемашина: недостаточно кофе");
            } else if (status.contains("Kettle")) {
                int water = parseValue(status, "Water: ", "ml");
                if (water < 200) issues.add("Чайник: недостаточно воды");
            } else if (status.contains("Stove")) {
                if (status.contains("OFF")) issues.add("Плита: выключена");
            } else if (status.contains("Oven")) {
                if (status.contains("OFF")) issues.add("Духовка: выключена");
            }
        }
        String report = issues.isEmpty() ? "Все компоненты в норме" : String.join("\n", issues);
        System.out.println(report);
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