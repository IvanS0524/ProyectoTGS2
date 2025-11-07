package logica.response;

import logica.alerting.Alert;
import logica.alerting.AlertLevel;

public class ResponseProtocol {
    public void execute(Alert alert) {
        if (alert == null) return;
        AlertLevel level = alert.getLevel();
        switch (level) {
            case RED:
                System.out.println("Protocolo RED: Evacuación, cierre de vías y activación de emergencia.");
                break;
            case ORANGE:
                System.out.println("Protocolo ORANGE: Preparación y aviso a entidades.");
                break;
            case YELLOW:
                System.out.println("Protocolo YELLOW: Vigilancia intensificada.");
                break;
            default:
                System.out.println("Protocolo GREEN: Operación normal.");
        }
    }
}