package logica;

import datos.DataRepository;
import logica.simulation.SimulationModel;
import logica.alerting.AlertManager;
import logica.response.ResponseProtocol;
import datos.SensorData;
import logica.simulation.Scenario;
import logica.alerting.Alert;

import java.time.Instant;
import java.util.List;

public class SystemController {
    private final DataRepository repository;
    private final SimulationModel model;
    private final AlertManager alertManager;
    private final ResponseProtocol responseProtocol;

    public SystemController(DataRepository repository, SimulationModel model, AlertManager alertManager, ResponseProtocol responseProtocol) {
        this.repository = repository;
        this.model = model;
        this.alertManager = alertManager;
        this.responseProtocol = responseProtocol;
    }

    public void runScenario(Scenario scenario) {
        System.out.println("Iniciando escenario: " + scenario.getName());
        List<SensorData> recent = repository.querySince(Instant.now().minusSeconds(30 * 60).toEpochMilli());
        Alert alert = model.evaluate(recent, scenario);

        if (alert != null) {
            alertManager.publish(alert);
            responseProtocol.execute(alert);
        } else {
            System.out.println("No se generó alerta para el escenario.");
        }
    }
}