class Fridge implements Device {
    private boolean isOn = true;
    private int milk = 500; // Количество молока в мл
    private int eggs = 1;  // Количество яиц

    @Override
    public String getStatus() {
        return "Холодильник " + (isOn ? "включен" : "выключен") + ", молока - " + milk + "мл, яиц - " + eggs + "шт";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю холодильник...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю холодильник...");
    }

    @Override
    public String checkProducts() {
        if (!isOn) return "Ошибка: холодильник выключен";
        StringBuilder status = new StringBuilder("В холодильнике: ");
        status.append("молока - ").append(milk).append("мл, яиц - ").append(eggs).append("шт");
        if (milk < 200) status.append(" (Мало молока!)");
        if (eggs < 2) status.append(" (Недостаточно яиц!)");
        return status.toString();
    }
}