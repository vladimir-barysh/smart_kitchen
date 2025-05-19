class IndustrialFridge implements Device {
    private final String type = "Fridge";
    private boolean isOn = true;
    private int milk = 5000; // Больший объём
    private int eggs = 100;
    @Override
    public String getStatus() {
        return "Промышленный холодильник - " + (isOn ? "включен" : "выключен") + ", молока - " + milk + "мл, яиц - " + eggs + "шт";
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю промышленный холодильник...");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю промышленный холодильник...");
    }
    @Override
    public String checkProducts() {
        if (!isOn) return "Ошибка: промышленный холодильник выключен";
        StringBuilder status = new StringBuilder("В промышленном холодильнике: ");
        status.append("молока - ").append(milk).append("мл, яиц - ").append(eggs).append("шт");
        if (milk < 1000) status.append(" (Мало молока!)");
        if (eggs < 20) status.append(" (Недостаточно яиц!)");
        return status.toString();
    }
    @Override
    public String getType() {
        return type;
    }
}