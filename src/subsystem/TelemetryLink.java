package subsystem;

import java.util.ArrayList;
import java.util.List;

public class TelemetryLink {
    private final List<String> log = new ArrayList<>();

    public void record(String event) {
        log.add(event);
    }

    public List<String> getLog() {
        return log;
    }
}
