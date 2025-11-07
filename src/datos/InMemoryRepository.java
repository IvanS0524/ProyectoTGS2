package datos;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class InMemoryRepository implements DataRepository {
    private final List<SensorData> storage = new CopyOnWriteArrayList<>();

    @Override public void onData(SensorData data) { save(data); }

    @Override
    public void save(SensorData data) {
        storage.add(data);
        System.out.println("Repositorio: guardado dato -> " + data.getType() + " = " + data.getValue());
    }

    @Override
    public List<SensorData> queryBySensor(String sensorId) {
        return storage.stream().filter(s -> s.getSensorId().equals(sensorId)).collect(Collectors.toList());
    }

    @Override
    public List<SensorData> querySince(long epochMilli) {
        return storage.stream().filter(s -> s.getTimestamp().toEpochMilli() >= epochMilli).collect(Collectors.toList());
    }
}