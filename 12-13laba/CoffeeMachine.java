class CoffeeMachine implements Device {
    private final String type = "CoffeeMachine";
    private DeviceState state;
    private boolean isOn = false;
    private int waterLevel = 100;
    private int coffeeLevel = 50;
    private static final int WATER_PER_COFFEE = 100;
    private static final int COFFEE_PER_COFFEE = 10;

    public CoffeeMachine(){
        this.state = new OffState();
    }

    public void setState(DeviceState state) { this.state = state; }
    public void dcWaterLevel(int value){ this.waterLevel -= value; }
    public void dcCoffeeLevel(int value){ this.coffeeLevel -= value; }
    public int getWaterLevel(){ return this.waterLevel; }
    public int getCoffeeLevel(){ return this.coffeeLevel; }

    @Override
    public CoffeeMachineMemento createMemento() {
        return new CoffeeMachineMemento(waterLevel, coffeeLevel, state);
    }
    @Override
    public void restoreMemento(CoffeeMachineMemento memento) {
        this.waterLevel = memento.getWaterLevel();
        this.coffeeLevel = memento.getCoffeeLevel();
        this.state = memento.getState();
        System.out.println("Состояние устройства вернулось до: " + getStatus());
    }

    @Override
    public String getStatus() {
        return state.getStatus(this);
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public void turnOn(CentralController controller) {
        state.turnOn(this, controller);
    }

    @Override
    public void turnOff(CentralController controller) {
        state.turnOff(this, controller);
    }

    @Override
    public String makeCoffee(CentralController controller) {
        return state.makeCoffee(this, controller);
    }
}