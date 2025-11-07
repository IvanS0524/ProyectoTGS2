package logica.alerting;

public class SirenAlertChannel implements AlertChannel {
    private final String sirenId;

    public SirenAlertChannel(String sirenId) { this.sirenId = sirenId; }

    @Override
    public void send(Alert alert) {
        System.out.println("Activando sirena " + sirenId + " por alerta: " + alert.getLevel());
    }
}