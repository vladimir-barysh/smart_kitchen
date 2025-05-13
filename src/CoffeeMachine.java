class CoffeeMachine implements Device {
    private boolean isOn = false;
    private int waterLevel = 100;
    private int coffeeLevel = 50;
    private static final int WATER_PER_COFFEE = 100;
    private static final int COFFEE_PER_COFFEE = 10;

    @Override
    public String getStatus() {
        return "Кофемашина " + (isOn ? "включена" : "выключена") + ", воды - " + waterLevel + "мл, кофе - " + coffeeLevel + "г";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю кофемашину...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю кофемашины...");
    }

    @Override
    public String makeCoffee() {
        if (!isOn) return "Ошибка: кофемашина выключена";
        if (waterLevel < WATER_PER_COFFEE) return "Ошибка: не хватает воды";
        if (coffeeLevel < COFFEE_PER_COFFEE) return "Ошибка: не хватает кофе";
        waterLevel -= WATER_PER_COFFEE;
        coffeeLevel -= COFFEE_PER_COFFEE;
        return "Кофе успешно приготовлено!";
    }
}