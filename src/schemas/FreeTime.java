package schemas;

import java.time.Duration;

public class FreeTime {

    private Duration duration;
    private int hours;
    private int minutes;
    /**
     * hours and minutes means that fractions of an hour that is not an integer should be in the minutes param
     * e.g. initializing 2 hours and 30 minutes as FreeTime should be FreeTime(2, 30);
     * Seconds should not be considered as users almost never would not consider seconds as part of free time
     * @param hours hours free to watch a movie
     * @param minutes minutes free to watch a movie
     */
    public FreeTime(int hours, int minutes) {
        Duration temp = Duration.ofHours(hours);
        duration = temp.plusMinutes(minutes);
        this.hours = hours;
        this.minutes = minutes;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        Duration temp = Duration.ofHours(hours);
        duration = temp.plusMinutes(this.minutes);
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        Duration temp = Duration.ofHours(hours);
        duration = temp.plusMinutes(minutes);
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        String hoursString = String.valueOf(this.hours);
        String minutesString = String.valueOf(this.minutes % 60);
        if (this.hours < 10) {
            hoursString = "0" + hoursString;
        }
        if (this.minutes % 60 < 10) {
            minutesString = "0" + minutesString;
        }
        return hoursString + ":" + minutesString;
    }
}
