package logica.sensors;

import datos.SensorData;
import datos.DataListener;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class TideGaugeSensor implements Sensor {
    private final String id;
    private final Location location;
    private final List<DataListener> listeners = new CopyOnWriteArrayList<>();

    public TideGaugeSensor(String id, Location loc) {
        this.id = id;
        this.location = loc;
    }

    @Override public String getId() { return id; }
    @Override public Location getLocation() { return location; }

    @Override
    public void produceData(SensorData data) {
        for (DataListener l : listeners) l.onData(data);
    }

    @Override public void registerListener(DataListener listener) { listeners.add(listener); }
    @Override public void unregisterListener(DataListener listener) { listeners.remove(listener); }
}