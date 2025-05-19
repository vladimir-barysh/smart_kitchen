class IndustrialKettle implements Device {
    private final String type = "Kettle";
    private boolean isOn = false;
    private int waterLevel = 2000; // Больший объём для промышленного использования
    private static final int WATER_PER_BOIL = 500;
    @Override
    public String getStatus() {
        return "Промышленный чайник - " + (isOn ? "включен" : "выключен") + ", воды - " + waterLevel + "мл";
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю промышленный чайник...");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю промышленный чайник...");
    }
    @Override
    public String boilWater() {
        if (!isOn) return "Ошибка: промышленный чайник выключен";
        if (waterLevel < WATER_PER_BOIL) return "Ошибка: недостаточно воды";
        waterLevel -= WATER_PER_BOIL;
        return "Вода успешно вскипятилась!";
    }
    @Override
    public String getType() {
        return type;
    }
}