public interface Device {
    void turnOn();
    void turnOff();
    String getStatus();
    String getDeviceType();
    default String makeCoffee() {
        return "Not supported";
    }
    default String boilWater() {
        return "Not supported";
    }
    default String heatStove(int temperature){return "Not supported";}
    default String heatOven(int timeMin, int temperature) {return "Not supported";}
}
