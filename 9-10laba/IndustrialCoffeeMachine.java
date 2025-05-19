public class IndustrialCoffeeMachine implements Device {
    private final String type = "CoffeeMachine";
    private boolean isOn = false;
    private int waterLevel = 1000; // Больше воды для промышленного использования
    private int coffeeLevel = 500; // Больше кофе

    @Override
    public String getStatus() {
        return "Промышленная кофемашина - " + (isOn ? "включена" : "выключена") + ", воды - " + waterLevel + "мл, кофе - " + coffeeLevel + "г";
    }
    @Override
    public String boilWater() {
        return Device.super.boilWater();
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю промышленную кофемашину...");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю промышленную кофемашину...");
    }
    @Override
    public String makeCoffee() {
        if (!isOn) return "Ошибка: промышленная кофемашина выключена";
        if (waterLevel < 100) return "Ошибка: не хватает воды";
        if (coffeeLevel < 10) return "Ошибка: не хватает кофе";
        waterLevel -= 100;
        coffeeLevel -= 10;
        return "Промышленное кофе успешно приготовлено!";
    }
    @Override
    public String getType() {
        return type;
    }
}