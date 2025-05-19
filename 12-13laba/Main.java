public class Main {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        ScheduleManager schedule = new ScheduleManager();
        DeviceChecker checker = new DeviceChecker();
        CentralController controller = new CentralController(receipt, schedule, checker);
        checker.setController(controller);

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        ProxyDevice coffeeProxy = new ProxyDevice(coffeeMachine);

        controller.addDevice(coffeeProxy);

        System.out.println("\n-=Проверка устройств=-\n");
        controller.checkDevices();
        controller.sendAlert();

        System.out.println("\n-=Получение задач=-\n");
        schedule.setSchedule(new Task("06:00", ActionConstants.MAKE_COFFEE));
        schedule.setSchedule(new Task("06:30", ActionConstants.MAKE_COFFEE));

        System.out.println("\n\n-=Первое приготовление кофе=-\n");
        System.out.println("Состояние до включения: " + coffeeMachine.getStatus() + "\n");
        controller.executeSchedule("06:00");
        System.out.println("\nСостояние после первой чашки кофе: " + coffeeMachine.getStatus());

        System.out.println("\n-=Возврат состояния до включенного, сразу же после приготовленного кофе=-\n");
        controller.restoreDeviceState(coffeeProxy, 1);

        System.out.println("\n\n-=Второе приготовление кофе=-\n");
        System.out.println("Состояние до второй чашки кофе: " + coffeeMachine.getStatus());
        controller.executeSchedule("06:30");
        System.out.println("\nСостояние после второй чашки кофе: " + coffeeMachine.getStatus());

        System.out.println("\n-=Проверка устройств=-\n");
        controller.checkDevices();
        System.out.println("\n-=Внимание=-\n");
        controller.sendAlert();

    }
}