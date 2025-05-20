class CoffeeMachine implements Device {
    private final String type = "CoffeeMachine";
    private boolean isOn = false;
    private int waterLevel = 100;
    private int coffeeLevel = 50;
    private static final int WATER_PER_COFFEE = 100;
    private static final int COFFEE_PER_COFFEE = 10;

    public int getWaterLevel(){ return this.waterLevel; }
    public int getCoffeeLevel(){ return this.coffeeLevel; }

    public void restoreResources(int water, int coffee) {
        waterLevel += water;
        coffeeLevel += coffee;
        System.out.println("Ресурсы восстановлены: вода +" + water + "мл, кофе +" + coffee + "г");
    }

    @Override
    public void accept(Visitor visitor){
        visitor.visit(this);
    }

    @Override
    public String getStatus() {
        return "Кофемашина - " + (isOn ? "включена" : "выключена") + ", воды - " + waterLevel + "мл, кофе - " + coffeeLevel + "г";
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Включаю кофемашину...");
        }else { System.out.println("Кофемашина уже включена"); }
    }

    @Override
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Выключаю кофемашину...");
        } else { System.out.println("Кофемашина уже выключена"); }
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