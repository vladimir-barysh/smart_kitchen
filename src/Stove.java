class Stove implements Device {
    private boolean isOn = false;
    private int currentTemperature = 0;

    @Override
    public String getStatus() {
        return "Stove is " + (isOn ? "ON" : "OFF") + ", Temperature: " + currentTemperature + "C";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Stove turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        currentTemperature = 0;
        System.out.println("Stove turned OFF");
    }

    @Override
    public String heatStove(int temperature) {
        if (!isOn) return "Error: Stove is OFF";
        if (temperature < 0 || temperature > 300) return "Error: Invalid temperature (0-300C)";
        currentTemperature = temperature;
        return "Stove heated to " + temperature + "C";
    }
}