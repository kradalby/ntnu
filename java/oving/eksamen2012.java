public class DayTime {
    public final int hours, minutes;

    public DayTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public String toString() {
        return hours + ":" + minutes;
    }

}


public class TimeSlot {
    
    final String description, int hour, int min, int dur;
    int durhour, int durmin;

    public TimeSlot (String desc, int hours, int min, int duration) {
        this.description = desc;
        this.hours = hours;
        this.min = min;
        this.dur = duration;
    }

    public String toString() {
        return descrition + "@" + getStartTime().toString() + "-" + getStopTime().toString();
    }

    public DayTime getStartTime() {
        return DayTime(this.hours, this.min)
    }
    
    public DayTime getStopTime() {
        hours(dur)
        return DayTime(this.hours+this.durhour, this.min+this.durmin)
    }

    public int getDuration() {
        return this.dur;
    }


    private void hours(int dur) {
        while (dur > 60) {
            if (dur > 60)i {
                dur - 60;
                this.durhour += 60;
            } else {
                this.durmin += dur;
            }
        }    
    }
}


public static void main(String[] args) {
    TimeSlot test = new TimeSlot(”TDT4100-forelesning”, 10, 15, 105)
    System.out.print(test.toString());

}
