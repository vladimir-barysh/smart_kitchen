public class Fridge implements Device{
    private boolean isOn = true;

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
        return "Холодильник " + (isOn ? "включен" : "выключен");
    }
}
