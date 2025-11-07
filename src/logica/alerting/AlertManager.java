package logica.alerting;

import java.util.ArrayList;
import java.util.List;

public class AlertManager {
    private final List<AlertChannel> channels = new ArrayList<>();

    public void registerChannel(AlertChannel channel) { channels.add(channel); }
    public void unregisterChannel(AlertChannel channel) { channels.remove(channel); }

    public void publish(Alert alert) {
        if (alert == null) return;
        System.out.println("ALERT MANAGER: publicando -> " + alert);
        for (AlertChannel c : channels) c.send(alert);
    }
}