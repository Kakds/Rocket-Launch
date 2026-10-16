package subsystem;

public class GuidanceComputer {
    private String orbit;

    public void setOrbit(String orbit) {
        if (orbit == null || orbit.isBlank()) {
            throw new IllegalArgumentException("Orbit must not be empty");
        }
        this.orbit = orbit;
    }

    public void selfTest() {
        if (orbit == null) {
            throw new IllegalStateException("Set the orbit before the self-test");
        }
    }
}
