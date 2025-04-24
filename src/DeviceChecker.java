import java.util.List;

// Реализация чекера
class DeviceChecker implements Checker {
    private CentralController controller;

    public DeviceChecker(CentralController controller) {
        this.controller = controller;
    }

    @Override
    public String checkAvailability() {
        return "Checking availability of components...";
    }

    @Override
    public String reportStatus(List<ProxyDevice> devices) {
        StringBuilder report = new StringBuilder();
        boolean allComponentsOk = true;

        for (ProxyDevice device : controller.getDevices()) {
            String status = device.getStatus();
            if (status.contains("CoffeeMachine")) {
                // Проверяем уровень воды и кофе для кофемашины
                if (status.contains("Water: 0ml") || status.contains("Water: ") && Integer.parseInt(status.split("Water: ")[1].split("ml")[0]) < 100) {
                    report.append("CoffeeMachine: Insufficient water level\n");
                    allComponentsOk = false;
                }
                if (status.contains("Coffee: 0g") || status.contains("Coffee: ") && Integer.parseInt(status.split("Coffee: ")[1].split("g")[0]) < 10) {
                    report.append("CoffeeMachine: Insufficient coffee level\n");
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