package isp.lab6.exercise1;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SensorClusterTest {

    SensorReading s1 = new SensorReading(LocalDateTime.of(2017, 3, 14, 10, 34), 3.5);
    SensorReading s2 = new SensorReading(LocalDateTime.of(2016, 1, 1, 12, 12), 6);
    SensorReading s3 = new SensorReading(LocalDateTime.of(2016, 3, 14, 6, 1), 4);
    Sensor sensor = new Sensor(SENSOR_TYPE.PRESSURE, "#2", new ArrayList<>());
    SensorCluster sensorCluster;

    @Before
    public void init() {
        sensor.addSensorReading(s1);
        sensor.addSensorReading(s2);
        sensor.addSensorReading(s3);
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(sensor);
        sensors.add(new Sensor(SENSOR_TYPE.TEMPERATURE, "#4", new ArrayList<>()));
        sensorCluster = new SensorCluster(sensors);
    }

    @Test
    public void testAddSensor() {
        sensorCluster.addSensor("#3", SENSOR_TYPE.HUMIDITY);
        assertEquals("There should be a new sensor with id 3 and type humidity", "Sensor{type=HUMIDITY, id='#3', sensorReadings=[]}", sensorCluster.getSensorById("#3").toString());

        assertNull("Sensor is added and now should return null", sensorCluster.addSensor("#2", SENSOR_TYPE.TEMPERATURE));
    }

    @Test
    public void testWriteSensorReading() {
        assertTrue("We should insert new value in sensor #2", sensorCluster.writeSensorReading("#2", 3.3, LocalDateTime.of(2020, 4,4, 6, 7)));
        assertFalse("We should not insert new value in nonexistent sensor", sensorCluster.writeSensorReading("#6", 3.3, LocalDateTime.of(2020, 4,4, 6, 7)));
    }

    @Test
    public void testGetSensorById() {
        assertNull("We should not have sensor #6", sensorCluster.getSensorById("#6"));
        assertEquals("We should have sensor #2", "Sensor{type=TEMPERATURE, id='#4', sensorReadings=[]}", sensorCluster.getSensorById("#4").toString());
    }

    @Test
    public void testAddSensorWriting() {
        assertTrue("should add new writing", sensor.addSensorReading(new SensorReading(LocalDateTime.now(), 8)));
    }
}