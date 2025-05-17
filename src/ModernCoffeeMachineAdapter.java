public class ModernCoffeeMachineAdapter implements Device{
    private ModernCoffeeMachine machine;

    public ModernCoffeeMachineAdapter(ModernCoffeeMachine newCoFMachine) {
        this.machine = newCoFMachine;
    }

    @Override
    public String getStatus() {
        return machine.getModernStatus();
    }

    @Override
    public String getType(){
        return machine.getModernType();
    }

    @Override
    public void turnOn() {
        machine.turnModernOn();
    }

    @Override
    public void turnOff() {
        machine.turnModernOff();
    }

    @Override
    public String makeCoffee() {
        return machine.makeModernCoffee();
    }
}
