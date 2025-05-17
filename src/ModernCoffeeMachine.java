public class ModernCoffeeMachine {
    private String type = "CoffeeMachine";
    private boolean isOn = false;
    private int waterLevel = 500;
    private int coffeeLevel = 10;
    private static final int WATER_PER_COFFEE = 100;
    private static final int COFFEE_PER_COFFEE = 10;

    public String getModernStatus() {
        return "Новая кофемашина - " + (isOn ? "включена" : "выключена") + ", воды - " + waterLevel + "мл, кофе - " + coffeeLevel + "г";
    }

    public String getModernType(){
        return this.type;
    }

    public void turnModernOn() {
        isOn = true;
        System.out.println("Включаю новую кофемашину...");
    }

    public void turnModernOff() {
        isOn = false;
        System.out.println("Выключаю новую кофемашину...");
    }

    public String makeModernCoffee() {
        if (!isOn) return "Ошибка: новая кофемашина выключена";
        if (waterLevel < WATER_PER_COFFEE) return "Ошибка: не хватает воды";
        if (coffeeLevel < COFFEE_PER_COFFEE) return "Ошибка: не хватает кофе";
        waterLevel -= WATER_PER_COFFEE;
        coffeeLevel -= COFFEE_PER_COFFEE;
        return "Новое, усовершенствованное кофе успешно приготовлено!";
    }
}
