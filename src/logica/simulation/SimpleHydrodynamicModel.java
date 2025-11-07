package logica.simulation;

import datos.SensorData;
import logica.alerting.*;

import java.util.List;

public class SimpleHydrodynamicModel implements SimulationModel {

    @Override
    public Alert evaluate(List<SensorData> recentData, Scenario scenario) {
        double seaLevel = recentData.stream()
                .filter(d -> d.getType() == datos.SensorDataType.SEA_LEVEL)
                .mapToDouble(SensorData::getValue).average().orElse(0.0);

        double precip = recentData.stream()
                .filter(d -> d.getType() == datos.SensorDataType.PRECIPITATION)
                .mapToDouble(SensorData::getValue).average().orElse(0.0);

        double score = seaLevel + (precip * 0.02);

        if (score >= 1.5) return new Alert(AlertLevel.RED, "Alerta Roja: riesgo alto de inundación costera. Score=" + score);
        else if (score >= 1.0) return new Alert(AlertLevel.ORANGE, "Alerta Naranja: riesgo moderado. Score=" + score);
        else if (score >= 0.7) return new Alert(AlertLevel.YELLOW, "Alerta Amarilla: vigilancia. Score=" + score);
        else return null;
    }
}