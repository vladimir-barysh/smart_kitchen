import java.util.ArrayList;
import java.util.List;

// Компоновщик: Композитное действие (группа действий)
class ActionComposite implements ActionComponent {
    private String description;
    private List<ActionComponent> actions = new ArrayList<>();

    public ActionComposite(String description) {
        this.description = description;
    }

    public void addAction(ActionComponent action) {
        actions.add(action);
    }

    public void removeAction(ActionComponent action) {
        actions.remove(action);
    }

    @Override
    public void execute(Receipt receipt) {
        System.out.println("Executing composite action: " + description);
        for (ActionComponent action : actions) {
            action.execute(receipt);
        }
    }

    @Override
    public String getDescription() {
        return description;
    }
}