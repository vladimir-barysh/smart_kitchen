// Интерфейс чекера
interface Checker extends Observer {
    String checkAvailability();
    String reportStatus();
}