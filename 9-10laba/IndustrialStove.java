class IndustrialStove implements Device {
    private final String type = "Stove";
    private boolean isOn = false;
    private int currentTemperature = 0;
    @Override
    public String getStatus() {
        return "Промышленная плита - " + (isOn ? "включена" : "выключена") + ", температура - " + currentTemperature + "C";
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю промышленную плиту...");
    }
    @Override
    public void turnOff() {
        isOn = false;
        currentTemperature = 0;
        System.out.println("Выключаю промышленную плиту...");
    }
    @Override
    public String heatStove(int temperature) {
        if (!isOn) return "Ошибка: промышленная плита выключена";
        if (temperature < 0 || temperature > 500) return "Ошибка: недопустимая температура (0-500C)"; // Более высокая температура
        currentTemperature = temperature;
        return "Промышленная плита разогрета до " + temperature + "C";
    }
    @Override
    public String getType() {
        return type;
    }
}