
public interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
    String getType();
    default String makeCoffee() {
        return "Not supported";
    }
    void accept(Visitor visitor);
}
