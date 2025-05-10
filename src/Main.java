public class Main {
    public static void main(String[] args) {
        CentralController controller = new CentralController();
        ProxyDevice coffeeProxy = new ProxyDevice("Кофемашина");
        ProxyDevice kettleProxy = new ProxyDevice("Чайник");
        ProxyDevice stoveProxy = new ProxyDevice("Плита");
        ProxyDevice ovenProxy = new ProxyDevice("Духовка");
        controller.addDevice(coffeeProxy);
        controller.addDevice(kettleProxy);
        controller.addDevice(stoveProxy);
        controller.addDevice(ovenProxy);

        // Установка расписания
        System.out.println("-=Setting schedule=-");
        ScheduleManager schedule = new ScheduleManager();
        schedule.setSchedule(new Task("06:00", "Приготовить кофе"));
        schedule.setSchedule(new Task("06:00", "Вскипятить воду"));
        schedule.setSchedule(new Task("15:00", "Включить духовку", 60, 200));
        schedule.setSchedule(new Task("19:00", "Разогреть плиту", 190));
        controller.setSchedule(schedule);
        System.out.println();

        // Проверка состояния устройств
        System.out.println("-=Checking devices=-");
        controller.checkDevices();
        System.out.println();

        // Выполнение расписания для 6 утра
        System.out.println("-=Executing schedule=-");
        controller.executeSchedule("06:00");
        controller.executeSchedule("15:00");
        controller.executeSchedule("19:00");
        System.out.println();

        // Проверка состояния и отчет
        System.out.println("-=Checking devices=-");
        controller.checkDevices();
        System.out.println();
        System.out.println("-=Any alerts=-");
        controller.sendAlert();
    }
}