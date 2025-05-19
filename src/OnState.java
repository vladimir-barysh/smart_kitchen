class OnState implements DeviceState {
    public String getStatus(CoffeeMachine context) {
        return "(ON state) Кофемашина - включена, воды - " + context.getWaterLevel() + "мл, кофе - " + context.getCoffeeLevel() + "г";
    }

    public void turnOn(CoffeeMachine context, CentralController controller) {
        System.out.println("(ON state) Кофемашина УЖЕ включена");
    }

    public void turnOff(CoffeeMachine context, CentralController controller) {
        System.out.println("(ON state) Выключаю кофемашину...");
        context.setState(new OffState());
        controller.saveDeviceState(context);
        controller.updateDeviceStatus(context);
    }

    public String makeCoffee(CoffeeMachine context, CentralController controller) {
        if (context.getWaterLevel() < 100) {
            context.setState(new ErrorState("недостаточно воды"));
            controller.saveDeviceState(context);
            controller.updateDeviceStatus(context);
            return "(ON state) Ошибка: недостаточно воды";
        }
        if (context.getCoffeeLevel() < 10) {
            context.setState(new ErrorState("недостаточно кофе"));
            controller.saveDeviceState(context);
            controller.updateDeviceStatus(context);
            return "(ON state) Ошибка: недостаточно кофе";
        }
        context.dcWaterLevel(100);
        context.dcCoffeeLevel(10);
        System.out.println("(ON state) Кофе успешно приготовлено!");
        controller.saveDeviceState(context);
        controller.updateDeviceStatus(context);
        return "(ON state) Кофе успешно приготовлено!";
    }
}