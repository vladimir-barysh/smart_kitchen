class WorkingState implements DeviceState {
    public String getStatus(CoffeeMachine context) {
        return "(WORKING state) Кофемашина - готовит кофе, воды - " + context.getWaterLevel() + "мл, кофе - " + context.getCoffeeLevel() + "г";
    }

    public void turnOn(CoffeeMachine context, CentralController controller) {
        System.out.println("(WORKING state) Кофемашина УЖЕ готовит кофе");
    }

    public void turnOff(CoffeeMachine context, CentralController controller) {
        System.out.println("(WORKING state) Нельзя выключить, пока готовится кофе.");
    }

    public String makeCoffee(CoffeeMachine context, CentralController controller) {
        return "(WORKING state) Кофе УЖЕ готовится.";
    }
}
