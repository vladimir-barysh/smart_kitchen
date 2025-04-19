public class Fridge implements Device{
    private boolean isOn = false;
    private String name = "Fridge";

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is OFF");
    }

    public boolean getStatus() {
        return isOn;
    }

    public String getName() {
        return name;
    }
}
