package vista;

import logica.SystemController;
import logica.simulation.Scenario;
import datos.InMemoryRepository;
import logica.simulation.SimpleHydrodynamicModel;
import logica.alerting.AlertManager;
import logica.alerting.SMSAlertChannel;
import logica.alerting.SirenAlertChannel;
import logica.response.ResponseProtocol;
import logica.sensors.Sensor;
import logica.sensors.SensorFactory;
import logica.sensors.SensorType;
import logica.sensors.Location;
import datos.SensorData;
import datos.SensorDataType;

import java.time.Instant;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Repositorio de datos en memoria
        InMemoryRepository repository = new InMemoryRepository();

        // Crear sensores
        Sensor tide = SensorFactory.createSensor(SensorType.TIDE_GAUGE, "TG-01", new Location(10.4, -75.5));
        Sensor weather = SensorFactory.createSensor(SensorType.WEATHER_STATION, "WS-01", new Location(10.4, -75.5));

        // Registrar repositorio como listener
        tide.registerListener(repository);
        weather.registerListener(repository);

        // Modelo de simulación
        SimpleHydrodynamicModel model = new SimpleHydrodynamicModel();

        // Manager de alertas y canales
        AlertManager alertManager = new AlertManager();
        alertManager.registerChannel(new SMSAlertChannel("+57-3000000000"));
        alertManager.registerChannel(new SirenAlertChannel("PlazaMayor"));

        // Protocolos de respuesta
        ResponseProtocol responseProtocol = new ResponseProtocol();

        // Controlador
        SystemController controller = new SystemController(repository, model, alertManager, responseProtocol);

        // Simular llegada de datos
        tide.produceData(new SensorData(tide.getId(), Instant.now(), SensorDataType.SEA_LEVEL, 0.8));
        weather.produceData(new SensorData(weather.getId(), Instant.now(), SensorDataType.PRECIPITATION, 35.0));

        // Ejecutar escenario de prueba
        Scenario scenario = new Scenario.Builder()
                .withName("EventoPrueba")
                .withStartTime(Instant.now())
                .withDurationMinutes(60)
                .build();

        controller.runScenario(scenario);
    }
}