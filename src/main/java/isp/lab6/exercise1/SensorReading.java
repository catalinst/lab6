package isp.lab6.exercise1;

import java.time.LocalDateTime;

public class SensorReading implements Comparable<SensorReading> {
    private LocalDateTime dateAndTime;
    private double value;

    public SensorReading(LocalDateTime dateAndTime, double value) {
        this.dateAndTime = dateAndTime;
        this.value = value;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "dateAndTime=" + dateAndTime +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(SensorReading o) {
        int result = dateAndTime.compareTo(o.dateAndTime); // first added compared with second added, if first > second => negative nr
        if (result > 0) return 1;
        if (result < 0) return -1;
        return 0;
    }
}
