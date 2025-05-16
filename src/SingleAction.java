// Компоновщик: Одиночное действие
class SingleAction implements ActionComponent {
    private Task task;

    public SingleAction(Task task) {
        this.task = task;
    }

    @Override
    public void execute(Receipt receipt) {
        task.execute(receipt);
    }

    @Override
    public String getDescription() {
        return "Задача: " + task.getAction() + " в " + task.getTime();
    }
}