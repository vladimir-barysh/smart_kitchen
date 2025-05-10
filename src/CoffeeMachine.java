public class CoffeeMachine implements Device{
    private boolean isOn = false;
    private int waterLevel = 1000; // Уровень воды в мл
    private int coffeeLevel = 50; // Количество кофе в г
    private static final int WATER_PER_COFFEE = 100; // 100 мл воды на чашку
    private static final int COFFEE_PER_COFFEE = 10; // 10 г кофе на чашку


    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю кофемашину...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Включаю кофемашину...");
    }

    @Override
    public String getStatus() {
        return "Кофемашина " + (isOn ? "включена" : "выключена") +
                ", количество воды - " + waterLevel + "мл, количество кофе - " + coffeeLevel + "г";
    }

    @Override
    public String getDeviceType(){
        return "Кофемашина";
    }

    public String makeCoffee(){
        if (!isOn) {
            return "Ошибка: кофемашина выключена";
        }
        if (waterLevel < WATER_PER_COFFEE) {
            return "Ошибка: не хватает воды (" + waterLevel + "мл доступно, " + WATER_PER_COFFEE + "мл не хватает)";
        }
        if (coffeeLevel < COFFEE_PER_COFFEE) {
            return "Ошибка: не хватает кофе (" + coffeeLevel + "г доступно, " + COFFEE_PER_COFFEE + "г не хватает)";
        }

        waterLevel -= WATER_PER_COFFEE;
        coffeeLevel -= COFFEE_PER_COFFEE;
        return "Кофе успешно приготовлено! Остаток: Воды " + waterLevel + "мл, Кофе " + coffeeLevel + "г";
    }
}