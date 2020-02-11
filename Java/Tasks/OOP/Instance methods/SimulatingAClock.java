class Clock {

    int hours = 12;
    int minutes = 0;

    public void next() {
        hours = (hours = (hours * 60 + minutes + 1) / 60 % 12) == 0 ? 12 : hours;
        minutes = (minutes + 1) % 60;
    }
}
