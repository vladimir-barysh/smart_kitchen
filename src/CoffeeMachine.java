class CoffeeMachine implements Device {
    private boolean isOn = false;
    private int waterLevel = 100;
    private int coffeeLevel = 50;
    private static final int WATER_PER_COFFEE = 100;
    private static final int COFFEE_PER_COFFEE = 10;

    @Override
    public String getStatus() {
        return "CoffeeMachine is " + (isOn ? "ON" : "OFF") + ", Water: " + waterLevel + "ml, Coffee: " + coffeeLevel + "g";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("CoffeeMachine turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("CoffeeMachine turned OFF");
    }

    @Override
    public String makeCoffee() {
        if (!isOn) return "Error: CoffeeMachine is OFF";
        if (waterLevel < WATER_PER_COFFEE) return "Error: Not enough water";
        if (coffeeLevel < COFFEE_PER_COFFEE) return "Error: Not enough coffee";
        waterLevel -= WATER_PER_COFFEE;
        coffeeLevel -= COFFEE_PER_COFFEE;
        return "Coffee prepared successfully!";
    }
}