import java.util.ArrayList;
import java.util.List;

class Stove implements Device {
    private final String type = "Stove";
    private boolean isOn = false;
    private int currentTemperature = 0;

    @Override
    public String getStatus() {
        return "Плита - " + (isOn ? "включена" : "выключена") + ", температура - " + currentTemperature + "C";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю плиту...");
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public void turnOff() {
        isOn = false;
        currentTemperature = 0;
        System.out.println("Выключаю плиту...");
    }

    @Override
    public String heatStove(int temperature) {
        if (!isOn) return "Ошибка: плита выключена";
        if (temperature < 0 || temperature > 300) return "Ошибка: недопустимая температура (0-300C)";
        currentTemperature = temperature;
        return "Плита разогрета до " + temperature + "C";
    }
}