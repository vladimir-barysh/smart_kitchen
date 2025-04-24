import java.util.List;

// Интерфейс чекера
interface Checker {
    String checkAvailability();
    String reportStatus(List<ProxyDevice> devices);
}