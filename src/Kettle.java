// Реализация чайника
class Kettle implements Device {
    private boolean isOn = false;
    private int waterLevel = 500; // Уровень воды в мл (максимум 1000 мл)
    private static final int WATER_PER_BOIL = 200; // 200 мл воды на кипячение

    @Override
    public String getStatus() {
        return "Чайник " + (isOn ? "включен" : "выключен") + ", количество воды - " + waterLevel + "мл";
    }
    @Override
    public String getDeviceType(){
        return "Чайник";
    }
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю чайник...");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю чайник...");
    }

    @Override
    public String boilWater() {
        if (!isOn) {
            return "Ошибка: чайник выключен";
        }
        if (waterLevel < WATER_PER_BOIL) {
            return "Ошбика: недостаточно воды в чайнике (" + waterLevel + "мл доступно, " + WATER_PER_BOIL
                    + "мл необходимо)";
        }

        waterLevel -= 1;
        return "Вода вскипятилась! Осталось воды: " + waterLevel + "мл";
    }
}