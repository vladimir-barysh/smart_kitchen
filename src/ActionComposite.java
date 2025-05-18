import java.util.ArrayList;
import java.util.List;

public class ActionComposite implements ActionComponent {
    private String name;
    private List<ActionComponent> actions;

    public ActionComposite(String name) {
        this.name = name;
        this.actions = new ArrayList<>();
    }

    public void addAction(ActionComponent action) {
        actions.add(action);
    }

    @Override
    public void execute(Receipt receipt) {
        System.out.println("Получение задач на " + name + ":");
        for (ActionComponent action : actions) {
            action.execute(receipt);
        }
    }

    public String getName() {
        return this.name;
    }
}
