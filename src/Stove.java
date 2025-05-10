class Stove implements Device {
    private boolean isOn = false;

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Включаю плиту...");
    }
    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Выключаю плиту...");
    }
    @Override
    public String getStatus() {
        return "Плита " + (isOn ? "включена" : "выключена");
    }

    @Override
    public String getDeviceType() {
        return "Плита";
    }
    @Override
    public String heatStove(int temperature) {
        if (!isOn) {
            return "Ошибка: плита выключена";
        }
        return "Плита успешно разогрета до " + temperature + " градусов!";
    }
}
