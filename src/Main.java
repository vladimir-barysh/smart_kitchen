public class Main {
    public static void main(String[] args) {
        // Конфигурирование системы
        Receipt receipt = new Receipt();
        ScheduleInterface schedule = new ScheduleManager();
        DeviceChecker checker = new DeviceChecker();
        CentralController controller = new CentralController(receipt, schedule, checker);
        checker.setController(controller);

        // Создание устройств и прокси
        Device coffeeMachine = new CoffeeMachine();
        Device kettle = new Kettle();
        Device stove = new Stove();
        Device oven = new Oven();

        ProxyDevice coffeeProxy = new ProxyDevice(coffeeMachine);
        ProxyDevice kettleProxy = new ProxyDevice(kettle);
        ProxyDevice stoveProxy = new ProxyDevice(stove);
        ProxyDevice ovenProxy = new ProxyDevice(oven);

        // Добавление устройств
        controller.addDevice(coffeeProxy);
        controller.addDevice(kettleProxy);
        controller.addDevice(stoveProxy);
        controller.addDevice(ovenProxy);

        // Установка расписания
        schedule.setSchedule(new Task("06:00", ActionConstants.MAKE_COFFEE));
        schedule.setSchedule(new Task("07:00", ActionConstants.BOIL_WATER));
        schedule.setSchedule(new Task("08:00", ActionConstants.HEAT_STOVE, 200)); // Нагреть плиту до 200°C
        schedule.setSchedule(new Task("09:00", ActionConstants.HEAT_OVEN, 180, 30)); // Нагреть духовку до 180°C на 30 минут

        // Проверка состояния устройств
        controller.checkDevices();

        // Выполнение расписания для 8 утра (нагрев плиты)
        controller.executeSchedule("08:00");

        // Выполнение расписания для 9 утра (нагрев духовки)
        controller.executeSchedule("09:00");

        // Проверка состояния и отчет
        controller.checkDevices();
        controller.sendAlert();
    }
}