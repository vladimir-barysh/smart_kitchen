public class Kettle implements Device{
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Kettle turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Kettle turned OFF");
    }

    @Override
    public String getStatus() {
        return "Kettle is " + (isOn ? "ON" : "OFF");
    }
}