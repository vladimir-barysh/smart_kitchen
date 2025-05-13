class Kettle implements Device {
    private boolean isOn = false;
    private int waterLevel = 500;
    private static final int WATER_PER_BOIL = 200;

    @Override
    public String getStatus() {
        return "Kettle is " + (isOn ? "ON" : "OFF") + ", Water: " + waterLevel + "ml";
    }

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
    public String boilWater() {
        if (!isOn) return "Error: Kettle is OFF";
        if (waterLevel < WATER_PER_BOIL) return "Error: Not enough water";
        waterLevel -= WATER_PER_BOIL;
        return "Water boiled successfully!";
    }
}