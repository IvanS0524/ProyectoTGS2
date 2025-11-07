package datos;

import java.time.Instant;

public class SensorData {
    private final String sensorId;
    private final Instant timestamp;
    private final SensorDataType type;
    private final double value;

    public SensorData(String sensorId, Instant timestamp, SensorDataType type, double value) {
        this.sensorId = sensorId;
        this.timestamp = timestamp;
        this.type = type;
        this.value = value;
    }

    public String getSensorId() { return sensorId; }
    public Instant getTimestamp() { return timestamp; }
    public SensorDataType getType() { return type; }
    public double getValue() { return value; }
}