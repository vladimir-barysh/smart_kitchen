class Oven implements Device {
    private boolean isOn = false;
    private int currentTemperature = 0;
    private int remainingMinutes = 0;

    @Override
    public String getStatus() {
        return "Oven is " + (isOn ? "ON" : "OFF") + ", Temperature: " + currentTemperature + "C, Time remaining: " + remainingMinutes + "min";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Oven turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        currentTemperature = 0;
        remainingMinutes = 0;
        System.out.println("Oven turned OFF");
    }

    @Override
    public String heatOven(int temperature, int minutes) {
        if (!isOn) return "Error: Oven is OFF";
        if (temperature < 0 || temperature > 250) return "Error: Invalid temperature (0-250C)";
        if (minutes <= 0) return "Error: Invalid time (must be > 0)";
        currentTemperature = temperature;
        remainingMinutes = minutes;
        return "Oven heated to " + temperature + "C for " + minutes + " minutes";
    }
}