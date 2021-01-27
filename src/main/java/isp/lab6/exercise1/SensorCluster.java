package isp.lab6.exercise1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SensorCluster {
    private List<Sensor> sensors;

    public SensorCluster(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }


    // the real deal starts from here

    public Sensor addSensor(String sensorId, SENSOR_TYPE type) {
        // return an instance to the newly created Sensor object or null if a sensor with given id already exists
        Sensor find = sensors.stream().filter(s -> s.getId().equals(sensorId)).findFirst().orElse(null);

        // if we get a sensor that exists -> find will contains a sensor and we'll return null
        // if we get any sensor -> we can create a new sensor and return it
        if (find == null) {
            Sensor newSensor = new Sensor(type, sensorId, new ArrayList<>());
            sensors.add(newSensor);
            return newSensor;
        } else {
            return null;
        }
    }

    public boolean writeSensorReading(String sensorId, double value, LocalDateTime dateTime) {
        Sensor sensor = sensors.stream().filter(s -> s.getId().equals(sensorId)).findFirst().orElse(null);
        if (sensor != null) {
            sensor.addSensorReading(new SensorReading(dateTime, value));
            return true;
        } else {
            return false;
        }
    }

    public Sensor getSensorById(String sensorId) {
        return sensors.stream().filter(s -> s.getId().equals(sensorId)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "SensorCluster{" +
                "sensors=" + sensors +
                '}';
    }
}
