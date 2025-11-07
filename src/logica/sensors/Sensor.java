package logica.sensors;

import datos.SensorData;
import datos.DataListener;

public interface Sensor {
    String getId();
    Location getLocation();
    void produceData(SensorData data);
    void registerListener(DataListener listener);
    void unregisterListener(DataListener listener);
}