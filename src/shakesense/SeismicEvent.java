import java.time.LocalDate;

/**
 * Abstract class representing a seismic event (earthquake).
 * Demonstrates abstraction by defining common properties and an abstract method.
 */
public abstract class SeismicEvent {
    // Encapsulated fields with private access
    private int id;
    private String location;
    private double magnitude;
    private LocalDate date;

    // Constructor
    public SeismicEvent(int id, String location, double magnitude, LocalDate date) {
        this.id = id;
        this.location = location;
        this.magnitude = magnitude;
        this.date = date;
    }

    // Getters and setters for encapsulation
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Abstract method for polymorphism (overridden in subclasses)
    public abstract String getAlertMessage();

    // Common method to display event details
    public void displayEvent() {
        System.out.println("ID: " + id + ", Location: " + location + ", Magnitude: " + magnitude + ", Date: " + date);
        System.out.println("Alert: " + getAlertMessage());
    }
}