package isp.lab6.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {
        SensorReading s1 = new SensorReading(LocalDateTime.of(2017, 1, 14, 10, 34), 2.5);
        SensorReading s2 = new SensorReading(LocalDateTime.of(2017, 5, 14, 10, 34), 5.5);
        SensorReading s3 = new SensorReading(LocalDateTime.of(2016, 1, 14, 10, 34), 4);
        SensorReading s4 = new SensorReading(LocalDateTime.of(2018, 1, 14, 10, 34), 3);
        SensorReading s5 = new SensorReading(LocalDateTime.of(2017, 3, 14, 10, 34), 3.5);

        List<SensorReading> sensorReadings = new ArrayList<>();
        sensorReadings.add(s1); sensorReadings.add(s2); sensorReadings.add(s3); sensorReadings.add(s4); sensorReadings.add(s5);

        Sensor sensor = new Sensor(SENSOR_TYPE.HUMIDITY, "12", sensorReadings);
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(sensor);

        Sensor sensor2 = new Sensor(SENSOR_TYPE.TEMPERATURE, "14", new ArrayList<>());
        sensor2.addSensorReading(new SensorReading(LocalDateTime.of(2021, 1, 1, 10, 34), 23));
        sensors.add(sensor2);

        SensorCluster clusters = new SensorCluster(sensors);
        clusters.addSensor("15", SENSOR_TYPE.PRESSURE);
        clusters.getSensorById("15").addSensorReading(new SensorReading(LocalDateTime.of(2021, 1, 3, 10, 34), 23));
        clusters.writeSensorReading("12", 10, LocalDateTime.of(2020, 10, 10, 10, 34));

        System.out.println(clusters);

        System.out.println("Sorted by time:");
        System.out.println(clusters.getSensorById("12").getSensorReadingsSortedByDateAndTime());
        System.out.println("----------");
        System.out.println("Sorted by value:");
        System.out.println(clusters.getSensorById("12").getSensorReadingsSortedByValue());

    }
}
