public class Oven implements Device{
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Oven turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Oven turned OFF");
    }

    @Override
    public String getStatus() {
        return "Oven is " + (isOn ? "ON" : "OFF");
    }
}