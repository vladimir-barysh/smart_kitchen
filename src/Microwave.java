public class Microwave implements Device{
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Microwave turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Microwave turned OFF");
    }

    @Override
    public String getStatus() {
        return "Microwave is " + (isOn ? "ON" : "OFF");
    }
}