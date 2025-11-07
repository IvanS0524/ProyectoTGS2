package logica.simulation;

import java.time.Instant;

public class Scenario {
    private final String name;
    private final Instant startTime;
    private final long durationMinutes;

    private Scenario(Builder b) {
        this.name = b.name;
        this.startTime = b.startTime;
        this.durationMinutes = b.durationMinutes;
    }

    public String getName() { return name; }
    public Instant getStartTime() { return startTime; }
    public long getDurationMinutes() { return durationMinutes; }

    public static class Builder {
        private String name;
        private Instant startTime;
        private long durationMinutes;

        public Builder withName(String name) { this.name = name; return this; }
        public Builder withStartTime(Instant t) { this.startTime = t; return this; }
        public Builder withDurationMinutes(long m) { this.durationMinutes = m; return this; }
        public Scenario build() { return new Scenario(this); }
    }
}