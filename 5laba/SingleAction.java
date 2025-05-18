public class SingleAction implements ActionComponent{
    private Task task;
    public SingleAction(Task newTask){
        this.task = newTask;
    }
    @Override
    public void execute(Receipt receipt){
        task.execute(receipt);
    }
}
