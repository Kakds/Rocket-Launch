package facade;

public class LaunchFailedException extends Exception {
    public LaunchFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
