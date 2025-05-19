class IndustrialOven implements Device {
    private final String type = "Oven";
    private boolean isOn = false;
    private int currentTemperature = 0;
    private int remainingMinutes = 0;
    @Override
    public String getStatus() {
        return "Промышленная духовка - " + (isOn ? "включена" : "выключена") + ", температура - " + currentTemperature + "C, таймер - " + remainingMinutes + "мин";
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю промышленную духовку...");
    }
    @Override
    public void turnOff() {
        isOn = false;
        currentTemperature = 0;
        remainingMinutes = 0;
        System.out.println("Выключаю промышленную духовку...");
    }
    @Override
    public String heatOven(int temperature, int minutes) {
        if (!isOn) return "Ошибка: промышленная духовка выключена";
        if (temperature < 0 || temperature > 400) return "Ошибка: недопустимая температура (0-400C)"; // Более высокая температура
        if (minutes <= 0) return "Ошибка: недопустимое время (должно быть > 0)";
        currentTemperature = temperature;
        remainingMinutes = minutes;
        return "Промышленная духовка разогрета до " + temperature + "C на " + minutes + " минут";
    }
    @Override
    public String getType() {
        return type;
    }
}