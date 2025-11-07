package logica.alerting;

public class SMSAlertChannel implements AlertChannel {
    private final String phone;

    public SMSAlertChannel(String phone) { this.phone = phone; }

    @Override
    public void send(Alert alert) {
        System.out.println("SMS a " + phone + ": " + alert.getMessage());
    }
}