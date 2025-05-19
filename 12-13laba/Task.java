class Task {
    private String time;
    private String action;

    public Task(String time, String action) {
        this.time = time;
        this.action = action;
    }

    public String getTime() {
        return time;
    }
    public String getAction() {
        return action;
    }

    public void execute(CentralController controller, Receipt receipt) {
        System.out.println("Получение расписания: " + time + " - " + action);
        switch (action) {
            case ActionConstants.MAKE_COFFEE:
                receipt.makeCoffee(controller);
                break;
            default:
                System.out.println("Unknown action: " + action);
        }
    }
}