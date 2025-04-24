public class CoffeeMachine implements Device{
    private boolean isOn = false;
    private int waterLevel = 200; // Уровень воды в мл (максимум 1000 мл)
    private int coffeeLevel = 50; // Количество кофе в г (максимум 200 г)
    private static final int WATER_PER_COFFEE = 100; // 100 мл воды на чашку
    private static final int COFFEE_PER_COFFEE = 10; // 10 г кофе на чашку


    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Coffee machine turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Coffee machine turned OFF");
    }

    @Override
    public String getStatus() {
        return "CoffeeMachine is " + (isOn ? "ON" : "OFF") +
                ", Water: " + waterLevel + "ml, Coffee: " + coffeeLevel + "g";
    }

    @Override
    public String makeCoffee(){
        if (!isOn) {
            return "Error: CoffeeMachine is OFF";
        }
        if (waterLevel < WATER_PER_COFFEE) {
            return "Error: Not enough water (" + waterLevel + "ml available, " + WATER_PER_COFFEE + "ml needed)";
        }
        if (coffeeLevel < COFFEE_PER_COFFEE) {
            return "Error: Not enough coffee (" + coffeeLevel + "g available, " + COFFEE_PER_COFFEE + "g needed)";
        }

        waterLevel -= WATER_PER_COFFEE;
        coffeeLevel -= COFFEE_PER_COFFEE;
        return "Coffee prepared successfully! Remaining: Water " + waterLevel + "ml, Coffee " + coffeeLevel + "g";
    }
}