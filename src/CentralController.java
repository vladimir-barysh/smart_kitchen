import java.util.ArrayList;
import java.util.List;

public class CentralController {
    private List<ProxyDevice> devices;

    public CentralController() {
        devices = new ArrayList<>();
    }

    public void addDevice(ProxyDevice device) {
        devices.add(device);
    }

    public void runChecks() {
        System.out.println("\nRunning scheduled checks:");
        for (ProxyDevice d : devices) {
            System.out.println(d.checkStatus());
        }
    }
}