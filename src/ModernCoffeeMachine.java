// Пример нового устройства (новая кофемашина)
class ModernCoffeeMachine implements ModernDevice {
    private boolean isPowered = false;
    private int waterLevel = 150;
    private int coffeeLevel = 75;

    @Override
    public String getCurrentState() {
        return "Новая кофемашина " + (isPowered ? "включена" : "выключена") + ", воды: " + waterLevel + "мл, кофе: " + coffeeLevel + "г";
    }

    @Override
    public void powerOn() {
        isPowered = true;
        System.out.println("Включаю новую кофемашину...");
    }

    @Override
    public void powerOff() {
        isPowered = false;
        System.out.println("Выключаю новую кофемашину...");
    }

    @Override
    public String brewCoffee() {
        if (!isPowered) return "Ошибка: новая кофемашина выключена";
        if (waterLevel < 100) return "Ошибка: не хватает воды";
        if (coffeeLevel < 10) return "Ошибка: не хватает кофе";
        waterLevel -= 100;
        coffeeLevel -= 10;
        return "Кофе из новой кофемашины успешно приготовлено!";
    }
}