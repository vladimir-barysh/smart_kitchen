public interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
    default String makeCoffee() {
        return "Not supported";
    }
}
