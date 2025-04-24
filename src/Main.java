// Пример использования
public class Main {
    public static void main(String[] args) {
        CentralController controller = new CentralController();

        ProxyDevice coffeeProxy = new ProxyDevice("CoffeeMachine");
        controller.addDevice(coffeeProxy);

        // Проверка состояния устройств
        controller.checkDevices();

        // Включение кофемашины и приготовление кофе
        coffeeProxy.turnOn();
        controller.checkDevices();
        System.out.println(controller.makeCoffee("CoffeeMachine"));
        controller.sendAlert();

        //Установление расписания
        ScheduleManager schedule = new ScheduleManager();
        schedule.setSchedule("Make coffee every morning at 6:00 am");
        controller.addSchedule(schedule);
        controller.executeSchedule();

        // Повторное приготовление кофе
        System.out.println(controller.makeCoffee("CoffeeMachine"));

        // Проверка состояния после приготовления
        controller.checkDevices();

        controller.sendAlert();
    }
}