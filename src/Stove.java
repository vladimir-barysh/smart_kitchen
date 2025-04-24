class Stove implements Device {
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Stove turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Stove turned OFF");
    }

    @Override
    public String getStatus() {
        return "Stove is " + (isOn ? "ON" : "OFF");
    }

}
