import java.util.ArrayList;
import java.util.List;

public class ResourceCheckerVisitor implements Visitor {
    private List<String> issues = new ArrayList<>();

    @Override
    public void visit(CoffeeMachine coffeeMachine) {
        String status = coffeeMachine.getStatus();
        int water = parseValue(status, "воды - ", "мл");
        int coffee = parseValue(status, "кофе - ", "г");
        if (water < 100) {
            issues.add(coffeeMachine.getType() + ": недостаточно воды (" + water + "мл)");
        }
        if (coffee < 10) {
            issues.add(coffeeMachine.getType() + ": недостаточно кофе (" + coffee + "г)");
        }
    }

    public String getReport() {
        String report = issues.isEmpty() ? "Все ресурсы в норме" : String.join("\n", issues);
        issues.clear(); // Очистка списка после формирования отчёта
        return report;
    }

    private int parseValue(String status, String prefix, String suffix) {
        try {
            return Integer.parseInt(status.split(prefix)[1].split(suffix)[0]);
        } catch (Exception e) {
            return 0;
        }
    }
}
