// Пример использования
public class Main {
    public static void main(String[] args) {
        CentralController controller = new CentralController();

        ProxyDevice coffeeProxy = new ProxyDevice("Кофемашина");
        controller.addDevice(coffeeProxy);

        // Проверка состояния устройств
        controller.checkDevices();

        // Включение кофемашины и приготовление кофе
        coffeeProxy.turnOn();
        controller.checkDevices();
        System.out.println(controller.makeCoffee("Кофемашина"));
        controller.sendAlert();

        //Установление расписания
        ScheduleManager schedule = new ScheduleManager();
        schedule.setSchedule("Заваривать чашку кофе каждое утро в 6.00");
        controller.addSchedule(schedule);
        controller.executeSchedule();

        // Повторное приготовление кофе
        System.out.println(controller.makeCoffee("Кофемашина"));

        // Проверка состояния после приготовления
        controller.checkDevices();

        controller.sendAlert();
    }
}