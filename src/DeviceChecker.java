import java.util.Objects;

// Реализация чекера
class DeviceChecker implements Checker {
    private CentralController controller;

    public DeviceChecker(CentralController controller) {
        this.controller = controller;
    }

    @Override
    public String checkAvailability() {
        return "Проверка доступности компонентов...";
    }

    @Override
    public String reportStatus() {
        StringBuilder report = new StringBuilder();
        boolean allComponentsOk = true;

        for (ProxyDevice device : controller.getDevices()) {
            String status = device.getStatus();
            if (status.contains("Кофемашина")) {
                int water = parseValue(status, "количество воды - ", "мл");
                int coffee = parseValue(status, "количество кофе - ", "г");
                if (water < 100) {
                    report.append("Кофемашина: недостаточно воды\n");
                    allComponentsOk = false;
                }
                if (coffee < 10) {
                    report.append("Кофемашина: недостаточно кофе\n");
                    allComponentsOk = false;
                }
            } else if (status.contains("Чайник")) {
                int water = parseValue(status, "количество воды - ", "мл");
                if (water < 200) {
                    report.append("Чайник: недостаточно воды\n");
                    allComponentsOk = false;
                }
            }
        }

        if (allComponentsOk) {
            report.append("Все компоненты в норме");
        }
        String result = report.toString();
        return result;
    }

    private int parseValue(String status, String prefix, String suffix) {
        try {
            String value = status.split(prefix)[1].split(suffix)[0];
            return Integer.parseInt(value);
        } catch (Exception e) {
            return 0;
        }
    }
}