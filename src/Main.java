public class Main {
    public static void main(String[] args) {
        // Конфигурирование системы
        Receipt receipt = new Receipt();
        ScheduleInterface schedule = new ScheduleManager();
        DeviceChecker checker = new DeviceChecker();
        CentralController controller = new CentralController(receipt, schedule, checker);
        checker.setController(controller);

        // Создаем устройств
        Device coffeeMachine = new CoffeeMachine();
        Device kettle = new Kettle();
        Device stove = new Stove();
        Device oven = new Oven();
        Device fridge = new Fridge();
        // Создаем объект с помощью адаптера
        Device modernCoffeeMachine = new ModernCoffeeMachineAdapter(new ModernCoffeeMachine());

        // Создаем объект для логирования (духовка, холодильник)
        LoggingDecorator ovenDecorator = new LoggingDecorator(oven);
        LoggingDecorator fridgeDecorator = new LoggingDecorator(fridge);

        // Создаем прокси
        ProxyDevice coffeeProxy = new ProxyDevice(coffeeMachine);
        ProxyDevice kettleProxy = new ProxyDevice(kettle);
        ProxyDevice stoveProxy = new ProxyDevice(stove);
        ProxyDevice ovenProxy = new ProxyDevice(ovenDecorator);
        ProxyDevice fridgeProxy = new ProxyDevice(fridgeDecorator);
        ProxyDevice modernCoffeeProxy = new ProxyDevice(modernCoffeeMachine);

        // Добавление устройств
        controller.addDevice(coffeeProxy);
        controller.addDevice(kettleProxy);
        controller.addDevice(stoveProxy);
        controller.addDevice(ovenProxy);
        controller.addDevice(fridgeProxy);

        // Установка расписания
        schedule.setSchedule(new Task("07:00", ActionConstants.BOIL_WATER));
        schedule.setSchedule(new Task("09:00", ActionConstants.HEAT_OVEN, 180, 30));
        schedule.setSchedule(new Task("20:00", ActionConstants.CHECK_PRODUCTS));

        // Проверка состояния устройств
        System.out.println("\n-=Проверка устройств=-\n");
        controller.checkDevices();

        // Выполнение алгоритма для завтрака
        System.out.println();
        ActionComposite breakfast = new ActionComposite("Завтрак");
        breakfast.addAction(new SingleAction(new Task("06:00", ActionConstants.MAKE_COFFEE)));
        breakfast.addAction(new SingleAction(new Task("06:30", ActionConstants.HEAT_STOVE, 70)));
        schedule.setRoutine("06:00", breakfast);

        // Выполнение расписания на завтрак
        System.out.println("\n-=Завтрак=-\n");
        controller.executeSchedule("06:00");

        // Выполнение расписания для 9 утра (включить духовку)
        System.out.println("\n-=09:00=-\n");
        controller.executeSchedule("09:00");

        // Выполнение расписания для 20:00 (проверить продукты)
        System.out.println("\n-=20:00=-\n");
        controller.executeSchedule("20:00");

        // Проверка адаптера
        System.out.println();
        controller.addDevice(modernCoffeeProxy);
        schedule.setSchedule(new Task("01:00", ActionConstants.MAKE_COFFEE));
        System.out.println("\n-=01:00=-\n");
        controller.executeSchedule("01:00");

        // Проверка состояния и отчет
        System.out.println("\n-=Проверка устройств=-\n");
        controller.checkDevices();
        System.out.println("\n-=Неполадки=-\n");
        controller.sendAlert();

        // Логирование
        System.out.println("\n-=Логирование=-\n");
        controller.getAllActionLogs();

    }
}