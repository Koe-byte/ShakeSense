import java.time.LocalDate;

/**
 * Subclass for moderate earthquakes (magnitude 4.0–6.0).
 * Inherits from SeismicEvent and overrides getAlertMessage() for polymorphism.
 */
public class ModerateEarthquake extends SeismicEvent {
    public ModerateEarthquake(int id, String location, double magnitude, LocalDate date) {
        super(id, location, magnitude, date);
    }

    @Override
    public String getAlertMessage() {
        return "Moderate earthquake detected. Possible minor damage; stay alert.";
    }
}