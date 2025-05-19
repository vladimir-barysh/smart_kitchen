public class Main {
    public static void main(String[] args) {
        // Конфигурирование системы
        SmartKitchenFacade kitchen = new SmartKitchenFacade();

        // Инициализация системы с устройствами
        kitchen.initializeSystem(
                new CoffeeMachine(),
                new Kettle(),
                new Stove(),
                new Oven(),
                new Fridge()
        );

        // Настройка расписания
        System.out.println();
        kitchen.setUpTask("06:00", ActionConstants.MAKE_COFFEE);
        kitchen.setUpTask("06:15", ActionConstants.BOIL_WATER);
        kitchen.setUpTaskStove("06:30", ActionConstants.HEAT_STOVE, 70);
        kitchen.setUpTask("19:45", ActionConstants.BOIL_WATER);
        kitchen.setUpTask("20:00", ActionConstants.CHECK_PRODUCTS);

        // Запуск дня
        System.out.println();
        kitchen.startAction("06:00");
        kitchen.startAction("06:15");
        kitchen.startAction("06:30");
        kitchen.startAction("19:45");
        kitchen.startAction("20:00");

        // Проверка состояния системы
        System.out.println();
        kitchen.checkSystemStatus();
        System.out.println("\nКоличество уникально созданных действий - " + TaskTypeFactory.getTaskTypeCount());
    }
}