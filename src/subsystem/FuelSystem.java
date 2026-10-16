package subsystem;

public class FuelSystem {
    private static final double CAPACITY_TONS = 200;

    private double loadedTons;

    public void load(double tons) {
        if (tons > CAPACITY_TONS) {
            throw new IllegalStateException("Needs " + tons + " t of fuel, tank holds " + CAPACITY_TONS + " t");
        }
        loadedTons = tons;
    }

    public void drain() {
        loadedTons = 0;
    }

    public double getLoadedTons() {
        return loadedTons;
    }
}
