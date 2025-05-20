public class Main {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        ScheduleManager schedule = new ScheduleManager();
        CentralController controller = new CentralController(receipt, schedule);
        ResourceCheckerVisitor resourceChecker = new ResourceCheckerVisitor();
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        controller.addDevice(coffeeMachine);

        // Создание команд
        Command turnOnCommand = new TurnOnCommand(coffeeMachine); // Включить кофемашину
        Command makeCoffeeCommand = new MakeCoffeeCommand(coffeeMachine); // Приготовить кофе
        Command turnOffCommand = new TurnOffCommand(coffeeMachine); // Выключить кофемашину

        // Проверка устройства перед включением
        String report = controller.acceptVisitor(resourceChecker);
        System.out.println("\n-=Проверка ресурсов=-\n" + report);

        System.out.println("\n-=Получение задач=-\n");
        schedule.setSchedule(new Task("06:00", turnOnCommand));
        schedule.setSchedule(new Task("06:10", makeCoffeeCommand));
        schedule.setSchedule(new Task("06:15", turnOffCommand));

        System.out.println("\n\n-=Первая команда=-\n");
        System.out.println("Состояние устройства: " + coffeeMachine.getStatus() + "\n");
        controller.executeSchedule("06:00");

        // Проверка устройства после включения
        report = controller.acceptVisitor(resourceChecker);
        System.out.println("\n-=Проверка ресурсов=-\n" + report);

        System.out.println("\n\n-=Вторая команда=-\n");
        System.out.println("Состояние устройства: " + coffeeMachine.getStatus());
        controller.executeSchedule("06:10");
        System.out.println("Состояние устройства: " + coffeeMachine.getStatus());

        // Проверка устройства после приготовления кофе
        report = controller.acceptVisitor(resourceChecker);
        System.out.println("\n-=Проверка ресурсов=-\n" + report);

        // Отмена последнего действия
        System.out.println("\nОтмена последнего действия...");
        controller.undoLastTask();
        System.out.println("После отмены: " + coffeeMachine.getStatus());

        // Проверка устройства после отмены последнего действия
        report = controller.acceptVisitor(resourceChecker);
        System.out.println("\n-=Проверка ресурсов=-\n" + report);

        System.out.println("\n\n-=Третья команда=-\n");
        System.out.println("Состояние устройства: " + coffeeMachine.getStatus() + "\n");
        controller.executeSchedule("06:15");
        System.out.println("Состояние устройства: " + coffeeMachine.getStatus() + "\n");
    }
}