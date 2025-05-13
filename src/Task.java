class Task {
    private String time;
    private String action;
    private int temperature; // Для heatStove и heatOven
    private int minutes;     // Для heatOven

    public Task(String time, String action) {
        this(time, action, 0, 0);
    }

    public Task(String time, String action, int temperature) {
        this(time, action, temperature, 0);
    }

    public Task(String time, String action, int temperature, int minutes) {
        this.time = time;
        this.action = action;
        this.temperature = temperature;
        this.minutes = minutes;
    }

    public String getTime() {
        return time;
    }

    public String getAction() {
        return action;
    }

    public void execute(Receipt receipt) {
        System.out.println("Получение расписания: " + time + " - " + action);
        switch (action) {
            case ActionConstants.MAKE_COFFEE:
                receipt.makeCoffee();
                break;
            case ActionConstants.BOIL_WATER:
                receipt.boilWater();
                break;
            case ActionConstants.HEAT_STOVE:
                receipt.heatStove(temperature);
                break;
            case ActionConstants.HEAT_OVEN:
                receipt.heatOven(temperature, minutes);
                break;
            case ActionConstants.CHECK_PRODUCTS:
                receipt.checkProducts();
                break;
            default:
                System.out.println("Unknown action: " + action);
        }
    }
}