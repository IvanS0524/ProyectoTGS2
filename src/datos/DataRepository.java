package datos;

public interface DataRepository extends DataListener {
    void save(SensorData data);
    List<SensorData> queryBySensor(String sensorId);
    List<SensorData> querySince(long epochMilli);
}