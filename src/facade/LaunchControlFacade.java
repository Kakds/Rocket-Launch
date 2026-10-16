package facade;

import java.util.List;

import subsystem.FuelSystem;
import subsystem.GuidanceComputer;
import subsystem.TelemetryLink;
import subsystem.WeatherStation;

public class LaunchControlFacade {
    private static final double TONS_FUEL_PER_KG = 0.01;

    private final WeatherStation weather = new WeatherStation(18);
    private final FuelSystem fuel = new FuelSystem();
    private final GuidanceComputer guidance = new GuidanceComputer();
    private final TelemetryLink telemetry = new TelemetryLink();

    public List<String> launch(String mission, String orbit, double payloadKg) throws LaunchFailedException {
        try {
            checkWeather();
            fuel.load(payloadKg * TONS_FUEL_PER_KG);
            telemetry.record("Fuel loaded: " + fuel.getLoadedTons() + " t");
            guidance.setOrbit(orbit);
            guidance.selfTest();
            telemetry.record("Guidance ready for " + orbit);
            telemetry.record("Liftoff of " + mission + "!");
            return telemetry.getLog();
        } catch (RuntimeException e) {
            fuel.drain();
            throw new LaunchFailedException("Mission '" + mission + "' aborted", e);
        }
    }

    private void checkWeather() {
        if (!weather.isSafeForLaunch()) {
            throw new IllegalStateException("Unsafe weather");
        }
        telemetry.record("Weather OK");
    }
}
