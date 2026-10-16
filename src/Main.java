import facade.LaunchControlFacade;
import facade.LaunchFailedException;

public class Main {
    public static void main(String[] args) {
        launch("Aurora-1", "LEO", 5_000);   // success
        launch("Titan-X", "GEO", 30_000);   // too heavy
        launch("Nameless", " ", 2_000);     // invalid orbit
    }

    private static void launch(String mission, String orbit, double payloadKg) {
        System.out.println(" " + mission + " ");
        try {
            new LaunchControlFacade().launch(mission, orbit, payloadKg).forEach(System.out::println);
        } catch (LaunchFailedException e) {
            System.out.println(e.getMessage() + ": " + e.getCause().getMessage());
        }
    }
}
