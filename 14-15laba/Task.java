class Task {
    private String time;
    private Command command;

    public Task(String time, Command command) {
        this.time = time;
        this.command = command;
    }

    public String getTime() {
        return time;
    }

    public void execute() {
        command.execute();
    }
    public void undo() {
        System.out.println("Отмена задания на " + time);
        command.undo();
    }
}