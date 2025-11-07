package logica.simulation;

import datos.SensorData;
import logica.alerting.Alert;

import java.util.List;

public interface SimulationModel {
    Alert evaluate(List<SensorData> recentData, Scenario scenario);
}