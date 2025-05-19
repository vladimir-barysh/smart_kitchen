import java.util.ArrayList;
import java.util.List;

class DeviceChecker implements Checker {

    public DeviceChecker() {
        // Пустой конструктор
    }

    @Override
    public String checkAvailability() {
        CentralController controller = CentralController.getInstance();
        if (controller == null) return "Ошибка: контроллер не установлен";
        return "Проверка доступности компонентов...";
    }

    @Override
    public String reportStatus() {
        CentralController controller = CentralController.getInstance();
        if (controller == null) {
            String report = "Ошибка: контроллер не установлен";
            System.out.println(report);
            return report;
        }
        List<String> issues = new ArrayList<>();
        for (ProxyDevice device : controller.getDevices()) {
            String type = device.getType();
            String status = device.getStatus();
            int idDash = status.indexOf(" - ");
            String name = status.substring(0, idDash).trim();
            if (type == "CoffeeMachine") {
                int water = parseValue(status, "воды - ", "мл");
                int coffee = parseValue(status, "кофе - ", "г");
                if (water < 100) issues.add(name + ": недостаточно воды");
                if (coffee < 10) issues.add(name + ": недостаточно кофе");
            } else if (type == "Kettle") {
                int water = parseValue(status, "воды - ", "мл");
                if (water < 200) issues.add(name + ": недостаточно воды");
            } else if (type == "Fridge") {
                int milk = parseValue(status, "молока - ", "мл");
                int eggs = parseValue(status, "яиц - ", "шт");
                if (milk < 200) issues.add(name + ": мало молока");
                if (eggs < 2) issues.add(name + ": мало яиц");
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