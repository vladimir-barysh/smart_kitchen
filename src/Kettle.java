class Kettle implements Device {
    private String type = "Kettle";
    private boolean isOn = false;
    private int waterLevel = 500;
    private static final int WATER_PER_BOIL = 200;

    @Override
    public String getStatus() {
        return "Чайник - " + (isOn ? "включен" : "выключен") + ", воды - " + waterLevel + "мл";
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю чайник...");
    }

    @Override
    public String getType(){
        return this.type;
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю чайник...");
    }

    @Override
    public String boilWater() {
        if (!isOn) return "Ошибка: чайник выключен";
        if (waterLevel < WATER_PER_BOIL) return "Ошибка: недостаточно воды";
        waterLevel -= WATER_PER_BOIL;
        return "Вода успешно вскипятилась!";
    }
}