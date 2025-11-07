package logica.sensors;

public class SensorFactory {
    public static Sensor createSensor(SensorType type, String id, Location loc) {
        switch (type) {
            case TIDE_GAUGE: return new TideGaugeSensor(id, loc);
            case WEATHER_STATION: return new WeatherStationSensor(id, loc);
            default: throw new IllegalArgumentException("Tipo de sensor no soportado");
        }
    }
}