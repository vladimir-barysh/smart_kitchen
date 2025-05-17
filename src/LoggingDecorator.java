import java.util.ArrayList;
import java.util.List;

public class LoggingDecorator implements Device{
    private List<String> log;
    private Device device;
    public LoggingDecorator(Device newDevice){
        this.device = newDevice;
        this.log = new ArrayList<>();
    }

    public List<String> getLog(){
        return new ArrayList<>(log);
    }

    @Override
    public String getStatus() {
        return device.getStatus();
    }

    @Override
    public String getType(){
        return device.getType();
    }

    @Override
    public void turnOn() {
        device.turnOn();
        log.add("Журнал: устройство было включено");
    }

    @Override
    public void turnOff() {
        device.turnOff();
        log.add("Журнал: устройство было выключено");
    }

    @Override
    public String makeCoffee() {
        log.add("Журнал: кофе было сделано");
        return device.makeCoffee();
    }

    @Override
    public String boilWater() {
        log.add("Журнал: вода была вскипячина");
        return device.boilWater();
    }

    @Override
    public String heatStove(int temperature) {
        log.add("Журнал: плита была разогрета до " + temperature + " градусов");
        return device.heatStove(temperature);
    }

    @Override
    public String heatOven(int temperature, int minutes) {
        log.add("Журнал: духовка была разогрета до " + temperature + " градусов на " + minutes + " минут");
        return device.heatOven(temperature, minutes);
    }

    @Override
    public String checkProducts() {
        log.add("Журнал: холодильник был проверен");
        return device.checkProducts();
    }
}
