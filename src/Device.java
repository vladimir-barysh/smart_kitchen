public interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
    String getType();
    default String makeCoffee() {
        return "Not supported";
    }
    default String boilWater() {
        return "Not supported";
    }
    default String heatStove(int temperature){return "Not supported";}
    default String heatOven(int temperature, int minutes) {return "Not supported";}
    default String checkProducts() {
        return "Not supported";
    }
}
