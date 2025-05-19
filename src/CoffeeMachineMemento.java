class CoffeeMachineMemento {
    private final int waterLevel;
    private final int coffeeLevel;
    private final DeviceState state;

    public CoffeeMachineMemento(int waterLevel, int coffeeLevel, DeviceState state) {
        this.waterLevel = waterLevel;
        this.coffeeLevel = coffeeLevel;
        this.state = state;
    }

    public int getWaterLevel() { return waterLevel; }
    public int getCoffeeLevel() { return coffeeLevel; }
    public DeviceState getState() { return state; }
}