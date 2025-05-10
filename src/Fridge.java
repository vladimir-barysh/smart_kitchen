import java.util.List;

public class Fridge implements Device{
    private boolean isOn = true;
    private int milkCount = 3;
    private int eggsCount = 10;
    private int tomatoesCount = 4;
    private int breadCount = 1;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Холодильник включается...");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Холодильник выключается...");
    }
    @Override
    public String getStatus() {
        return "Холодильник " + (isOn ? "включен" : "выключен") + ", пачек молока - " + milkCount + " шт, яиц - "
                + eggsCount + " шт, помидоров - " + tomatoesCount + " шт, кусков хлеба - " + breadCount + " шт";
    }
    @Override
    public String getDeviceType(){
        return "Холодильник";
    }
}
