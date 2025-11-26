import java.time.LocalDate;

/**
 * Subclass for major earthquakes (magnitude > 6.0).
 * Inherits from SeismicEvent and overrides getAlertMessage() for polymorphism.
 */
public class MajorEarthquake extends SeismicEvent {
    public MajorEarthquake(int id, String location, double magnitude, LocalDate date) {
        super(id, location, magnitude, date);
    }

    @Override
    public String getAlertMessage() {
        return "Major earthquake detected! Evacuate immediately and seek shelter.";
    }
}