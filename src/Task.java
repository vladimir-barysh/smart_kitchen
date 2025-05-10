class Task {
    private String time; // Время выполнения (например, "06:00")
    private String action; // Действие (например, "makeCoffee")
    private int temperature;
    private int heatTime;

    public Task(String time, String action) {
        this.time = time;
        this.action = action;
    }
    public Task(String time, String action, int temperature){
        this.time = time;
        this.action = action;
        this.temperature = temperature;
    }
    public Task(String time, String action, int heatTimeMin, int temperature){
        this.time = time;
        this.action = action;
        this.heatTime = heatTimeMin;
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public void execute(Receipt receipt) {
        System.out.println("Получена задача: " + time + " - " + action);
        switch (action) {
            case "Приготовить кофе":
                receipt.makeCoffee();
                break;
            case "Вскипятить воду":
                receipt.boilWater();
                break;
            case "Разогреть плиту":
                receipt.heatStove(temperature);
                break;
            case "Включить духовку":
                receipt.heatOven(heatTime, temperature);
                break;
            default:
                System.out.println("Неизвестная задача: " + action);
        }
    }
}