class OffState implements DeviceState {
    public String getStatus(CoffeeMachine context) {
        return "(OFF state) Кофемашина - выключена, воды - " + context.getWaterLevel() + "мл, кофе - " + context.getCoffeeLevel() + "г";
    }

    public void turnOn(CoffeeMachine context, CentralController controller) {
        System.out.println("(OFF state) Включаю кофемашину...");
        context.setState(new OnState());
        controller.saveDeviceState(context);
        controller.updateDeviceStatus(context);
    }

    public void turnOff(CoffeeMachine context, CentralController controller) {
        System.out.println("(OFF state) Кофемашина УЖЕ выключена");
    }

    public String makeCoffee(CoffeeMachine context, CentralController controller) {
        return "(OFF state) Ошибка: кофемашина выключена";
    }
}