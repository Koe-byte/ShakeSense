import java.time.LocalDate;

/**
 * Subclass for minor earthquakes (magnitude < 4.0).
 * Inherits from SeismicEvent and overrides getAlertMessage() for polymorphism.
 */
public class MinorEarthquake extends SeismicEvent {
    public MinorEarthquake(int id, String location, double magnitude, LocalDate date) {
        super(id, location, magnitude, date);
    }

    @Override
    public String getAlertMessage() {
        return "Minor earthquake detected. No significant impact expected.";
    }
}