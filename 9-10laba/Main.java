public class Main {
    public static void main(String[] args) {
        // Создаём TaskPool
        TaskPool taskPool = new TaskPool(3);
        // Конфигурирование системы
        CentralController controller = CentralController.getInstance(taskPool);

        // Создание фабрик
        KitchenDeviceFactory homeFactory = new HomeKitchenDeviceFactory();
        KitchenDeviceFactory industrialFactory = new IndustrialKitchenDeviceFactory();

        // Создадим устройства промышленной кухни, но не будем добавлять в контроллер. Сделаем это для демонстрации
        industrialFactory.createCoffeeMachine();
        industrialFactory.createFridge();
        industrialFactory.createKettle();
        industrialFactory.createOven();
        industrialFactory.createStove();

        // Добавление устройств через фабрики
        System.out.println();
        controller.addDevice(homeFactory.createCoffeeMachine());
        controller.addDevice(homeFactory.createKettle());
        controller.addDevice(homeFactory.createStove());
        controller.addDevice(homeFactory.createOven());
        controller.addDevice(homeFactory.createFridge());

        // Вывод начального состояния
        System.out.println("\n-=Проверка устройств=-\n");
        controller.checkDevices();
        controller.sendAlert();

        // Настройка расписания
        ScheduleInterface schedule = controller.getSchedule();

        // Демонстрация Prototype: Создаём прототип задачи и клонируем её
        System.out.println("\n-= Демонстрация паттерна Prototype =-\n");
        Task coffeeTaskPrototype = new Task("06:30", "makeCoffee");
        System.out.println("Задача-прототип: " + coffeeTaskPrototype);

        Task coffeeTaskClone1 = coffeeTaskPrototype.clone("07:30");
        System.out.println("Склонированная задача 1: " + coffeeTaskClone1);

        Task coffeeTaskClone2 = coffeeTaskPrototype.clone("08:00");
        System.out.println("Склонированная задача 2: " + coffeeTaskClone2);

        // Демонстрация Object Pool: Используем пул для управления задачами
        System.out.println("\n-= Демонстрация паттерна Object Pool =-\n");
        // Первая волна задач
        System.out.println("Первая волна задач:");
        Task task1 = taskPool.acquireTask(coffeeTaskPrototype.getTime(), coffeeTaskPrototype.getAction());
        schedule.setSchedule(task1);

        Task task2 = taskPool.acquireTask(coffeeTaskClone1.getTime(), coffeeTaskClone1.getAction());
        schedule.setSchedule(task2);

        Task task3 = taskPool.acquireTask(coffeeTaskClone2.getTime(), coffeeTaskClone2.getAction());
        schedule.setSchedule(task3);

        // Выполняем расписание, чтобы освободить задачи
        System.out.println("\n-=06:30=-\n");
        controller.executeSchedule("06:30"); // Освобождаем task1
        System.out.println("\n-=07:30=-\n");
        controller.executeSchedule("07:30"); // Освобождаем task2
        System.out.println("\n-=08:00=-\n");
        controller.executeSchedule("08:00"); // Освобождаем task3

        // Вторая волна задач: Демонстрируем переиспользование задач из пула
        System.out.println("\nВторая волна задач (переиспользование из пула):");
        Task task4 = taskPool.acquireTask("09:00", "boilWater");
        schedule.setSchedule(task4);

        Task task5 = taskPool.acquireTask("10:00", "heatOven", 180, 30);
        schedule.setSchedule(task5);

        Task task6 = taskPool.acquireTask("11:00", "checkProducts");
        schedule.setSchedule(task6);

        // Выполняем вторую волну
        System.out.println("\n-=09:00=-\n");
        controller.executeSchedule("09:00");
        System.out.println("\n-=10:00=-\n");
        controller.executeSchedule("10:00");
        System.out.println("\n-=11:00=-\n");
        controller.executeSchedule("11:00");

        // Повторная проверка состояния
        System.out.println("\n-=Проверка устройств=-\n");
        controller.checkDevices();

        System.out.println("\n-=Внимание=-\n");
        controller.sendAlert();
    }
}