class Oven implements Device {
    private boolean isOn = false;
    private int currentTemperature = 0;
    private int remainingMinutes = 0;

    @Override
    public String getStatus() {
        return "Духовка " + (isOn ? "включена" : "выключена") + ", температура - " + currentTemperature + "C, таймер - " + remainingMinutes + "мин";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю духовку...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        currentTemperature = 0;
        remainingMinutes = 0;
        System.out.println("Выключаю духовку...");
    }

    @Override
    public String heatOven(int temperature, int minutes) {
        if (!isOn) return "Ошибка: духовка выключена";
        if (temperature < 0 || temperature > 250) return "Ошибка: недопустимая температура (0-250C)";
        if (minutes <= 0) return "Ошибка: недопустимое время (должно быть > 0)";
        currentTemperature = temperature;
        remainingMinutes = minutes;
        return "Духовка разогрета до " + temperature + "C на " + minutes + " минут";
    }
}