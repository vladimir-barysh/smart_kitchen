// Реализация менеджера расписания
class ScheduleManager implements ScheduleInterface {
    private String schedule;

    @Override
    public void setSchedule(String schedule) {
        this.schedule = schedule;
        System.out.println("Расписание установлено: " + schedule);
    }

    @Override
    public String getSchedule() {
        return schedule;
    }
}