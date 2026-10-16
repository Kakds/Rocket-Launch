package subsystem;

public class WeatherStation {
    private static final int MAX_SAFE_WIND_KMH = 40;

    private final int windKmh;

    public WeatherStation(int windKmh) {
        this.windKmh = windKmh;
    }

    public boolean isSafeForLaunch() {
        return windKmh <= MAX_SAFE_WIND_KMH;
    }
}
