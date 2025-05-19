
public interface Device {
    void turnOn(CentralController controller);
    void turnOff(CentralController controller);
    String getStatus();
    String getType();
    default String makeCoffee(CentralController controller) {
        return "Not supported";
    }
    CoffeeMachineMemento createMemento();
    void restoreMemento(CoffeeMachineMemento memento);
}
