/**
 * Custom exception for invalid magnitude inputs.
 * Used for exception handling in the program.
 */
public class InvalidMagnitudeException extends Exception {
    public InvalidMagnitudeException(String message) {
        super(message);
    }
}