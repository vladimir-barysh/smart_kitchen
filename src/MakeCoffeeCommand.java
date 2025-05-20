public class MakeCoffeeCommand implements Command{
    private CoffeeMachine coffeeMachine;
    private int waterUsed;
    private int coffeeUsed;

    public MakeCoffeeCommand(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
        this.waterUsed = 100;
        this.coffeeUsed = 10;
    }

    @Override
    public void execute() {
        int initialWater = coffeeMachine.getWaterLevel();
        int initialCoffee = coffeeMachine.getCoffeeLevel();
        String result = coffeeMachine.makeCoffee();
        if (result.contains("успешно")) {
            waterUsed = initialWater - coffeeMachine.getWaterLevel();
            coffeeUsed = initialCoffee - coffeeMachine.getCoffeeLevel();
        }
        System.out.println(result);
    }

    @Override
    public void undo() {
        if (waterUsed > 0 || coffeeUsed > 0) {
            coffeeMachine.restoreResources(waterUsed, coffeeUsed);
        } else {
            System.out.println("Отмена невозможна");
        }
    }
}
