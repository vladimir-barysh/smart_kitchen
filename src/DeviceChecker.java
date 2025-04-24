import java.util.List;

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
    public String reportStatus(List<ProxyDevice> devices) {
        StringBuilder report = new StringBuilder();
        boolean allComponentsOk = true;

        for (ProxyDevice device : controller.getDevices()) {
            String status = device.getStatus();
            if (status.contains("Кофемашина")) {
                // Проверяем уровень воды и кофе для кофемашины
                if (status.contains("Количество воды: 0мл") || status.contains("Количество воды: ") &&
                        Integer.parseInt(status.split("Количество воды: ")[1].split("мл")[0]) < 100) {
                    report.append("Кофемашина: недостаточно воды\n");
                    allComponentsOk = false;
                }
                if (status.contains("Количество кофе: 0г") || status.contains("Количество кофе: ") &&
                        Integer.parseInt(status.split("Количество кофе: ")[1].split("г")[0]) < 10) {
                    report.append("Кофемашина: недостаточно воды\n");
                    allComponentsOk = false;
                }
            }
            // Можно добавить проверки для других устройств
        }

        if (allComponentsOk) {
            report.append("0");
        }
        String result = report.toString();
        return result;
    }
}