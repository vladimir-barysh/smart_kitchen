public interface DeviceState {
    String getStatus(CoffeeMachine context);
    void turnOn(CoffeeMachine context, CentralController controller);
    void turnOff(CoffeeMachine context, CentralController controller);
    String makeCoffee(CoffeeMachine context, CentralController controller);
}
