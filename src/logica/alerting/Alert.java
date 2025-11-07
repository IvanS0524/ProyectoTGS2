package logica.alerting;

import java.time.Instant;

public class Alert {
    private final AlertLevel level;
    private final String message;
    private final Instant timestamp;

    public Alert(AlertLevel level, String message) {
        this.level = level;
        this.message = message;
        this.timestamp = Instant.now();
    }

    public AlertLevel getLevel() { return level; }
    public String getMessage() { return message; }
    public Instant getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + level + " - " + message;
    }
}