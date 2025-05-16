// Компоновщик: Интерфейс для действий
interface ActionComponent {
    void execute(Receipt receipt);
    String getDescription();
}