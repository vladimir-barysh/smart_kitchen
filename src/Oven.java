public class Oven implements Device{
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю духовку...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю духовку...");
    }
    @Override
    public String getStatus() {
        return "Духовка " + (isOn ? "включена" : "выключена");
    }
    @Override
    public String getDeviceType(){
        return "Духовка";
    }
    public String heatOven(int timeMin, int temperature){
        if (!isOn) {
            return "Ошибка: духовка выключена";
        }
        if (temperature > 0 || temperature <= 100){
            timeMin -= 2;
        }
        else if (temperature > 100 || temperature <= 200){
            timeMin -= 3;
        }
        else if (temperature > 200){
            timeMin -= 5;
        }
        else { return "Ошибка! Температура не может быть отрицательной!";}
        return "Духовка успешно разогрета до " + temperature + " градусов! Осталось " + timeMin + " мин до выключения.";
    }
}