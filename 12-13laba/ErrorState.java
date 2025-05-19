class ErrorState implements DeviceState {
    private String errorMessage;

    public ErrorState(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStatus(CoffeeMachine context) {
        return "(ERROR state) Кофемашина - не в рабочем состоянии: " + errorMessage + ", воды - " + context.getWaterLevel() + "мл, кофе - " + context.getCoffeeLevel() + "г";
    }

    public void turnOn(CoffeeMachine context, CentralController controller) {
        System.out.println("(ERROR state) Невозможно включить по причине: " + errorMessage);
    }

    public void turnOff(CoffeeMachine context, CentralController controller) {
        System.out.println("(ERROR state) Выключение кофемашины по причине: " + errorMessage);
        controller.saveDeviceState(context);
        controller.updateDeviceStatus(context);
        context.setState(new OffState());
    }

    public String makeCoffee(CoffeeMachine context, CentralController controller) {
        return "(ERROR state) Невозможно приготовить кофе по причине: " + errorMessage;
    }
}