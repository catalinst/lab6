package isp.lab6.exercise1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sensor implements Comparator<SensorReading> {
    private SENSOR_TYPE type;
    private String id;
    private List<SensorReading> sensorReadings;

    public Sensor(SENSOR_TYPE type, String id, List<SensorReading> sensorReadings) {
        this.type = type;
        this.id = id;
        this.sensorReadings = sensorReadings;
    }

    public SENSOR_TYPE getType() {
        return type;
    }

    public void setType(SENSOR_TYPE type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SensorReading> getSensorReadings() {
        return sensorReadings;
    }

    public void setSensorReadings(List<SensorReading> sensorReadings) {
        this.sensorReadings = sensorReadings;
    }


    // the real deal starts from here

    public List<SensorReading> getSensorReadingsSortedByDateAndTime() {
        Collections.sort(sensorReadings);
        return sensorReadings;
    }

    public List<SensorReading> getSensorReadingsSortedByValue() {
        Collections.sort(sensorReadings, this);
        return sensorReadings;
    }

    public boolean addSensorReading(SensorReading sensorReading) {
        return sensorReadings.add(sensorReading);
    }

    @Override
    public int compare(SensorReading o1, SensorReading o2) {
        if (o1.getValue() > o2.getValue()) return 1;
        if (o1.getValue() < o2.getValue()) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "type=" + type +
                ", id='" + id + '\'' +
                ", sensorReadings=" + sensorReadings +
                '}';
    }
}
