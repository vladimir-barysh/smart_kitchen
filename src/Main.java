public class Main {
    public static void main(String[] args) {
        // Конфигурирование системы
        Receipt receipt = new Receipt();
        ScheduleInterface schedule = new ScheduleManager();
        DeviceChecker checker = new DeviceChecker();
        CentralController controller = new CentralController(receipt, schedule, checker);
        checker.setController(controller);

        // Создание устройств и прокси
        Device modernCoffeeMachine = new ModernDeviceAdapter(new ModernCoffeeMachine());
        Device coffeeMachine = new CoffeeMachine();
        Device kettle = new Kettle();
        Device stove = new Stove();
        Device oven = new Oven();
        Device fridge = new Fridge();

        // Оборачиваем устройства в декоратор для логирования
        ProxyDevice modernCoffeeProxy = new ProxyDevice(new LoggingDeviceDecorator(modernCoffeeMachine));
        ProxyDevice coffeeProxy = new ProxyDevice(new LoggingDeviceDecorator(coffeeMachine));
        ProxyDevice kettleProxy = new ProxyDevice(new LoggingDeviceDecorator(kettle));
        ProxyDevice stoveProxy = new ProxyDevice(new LoggingDeviceDecorator(stove));
        ProxyDevice ovenProxy = new ProxyDevice(new LoggingDeviceDecorator(oven));
        ProxyDevice fridgeProxy = new ProxyDevice(new LoggingDeviceDecorator(fridge));

        // Добавление устройств
        controller.addDevice(modernCoffeeProxy);
        controller.addDevice(coffeeProxy);
        controller.addDevice(kettleProxy);
        controller.addDevice(stoveProxy);
        controller.addDevice(ovenProxy);
        controller.addDevice(fridgeProxy);

        // Установка расписания
        schedule.setSchedule(new Task("06:00", ActionConstants.MAKE_COFFEE));
        schedule.setSchedule(new Task("07:00", ActionConstants.BOIL_WATER));
        schedule.setSchedule(new Task("08:00", ActionConstants.HEAT_STOVE, 200));
        schedule.setSchedule(new Task("09:00", ActionConstants.HEAT_OVEN, 180, 30));

        // Компоновщик: Создание комплекса действий для завтрака
        ActionComposite breakfast = new ActionComposite("Завтрак");
        breakfast.addAction(new SingleAction(new Task("06:00", ActionConstants.MAKE_COFFEE)));
        breakfast.addAction(new SingleAction(new Task("08:00", ActionConstants.HEAT_STOVE, 200)));

        // Проверка состояния устройств с использованием итератора
        controller.checkDevices();

        // Выполнение комплекса действий для завтрака (включая ModernCoffeeMachine)
        System.out.println("\nПолучение алгоритма для завтрака:");
        breakfast.execute(receipt);

        // Вручную вызываем makeCoffee для ModernCoffeeMachine
        System.out.println("\nManually testing ModernCoffeeMachine:");
        receipt.makeCoffee();

        // Выполнение расписания для 20:00 (проверка продуктов)
        controller.executeSchedule("20:00");

        // Проверка состояния и отчет
        controller.checkDevices();
        controller.sendAlert();
    }
}