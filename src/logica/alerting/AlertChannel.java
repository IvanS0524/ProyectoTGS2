package logica.alerting;

public interface AlertChannel {
    void send(Alert alert);
}