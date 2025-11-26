import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for ShakeSense earthquake monitoring system.
 * Provides CRUD operations via console menu.
 * Uses ArrayList to manage SeismicEvent objects.
 */
public class ShakeSense {
    private static ArrayList<SeismicEvent> events = new ArrayList<>();
    private static int nextId = 1; // Auto-increment ID for events
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to ShakeSense - Earthquake Monitoring System");

        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    createEvent();
                    break;
                case 2:
                    readEvents();
                    break;
                case 3:
                    updateEvent();
                    break;
                case 4:
                    deleteEvent();
                    break;
                case 5:
                    System.out.println("Exiting ShakeSense. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Display menu
    private static void displayMenu() {
        System.out.println("\n--- ShakeSense Menu ---");
        System.out.println("1. Create Earthquake Event");
        System.out.println("2. Read/View Earthquake Events");
        System.out.println("3. Update Earthquake Event");
        System.out.println("4. Delete Earthquake Event");
        System.out.println("5. Exit");
    }

    // CREATE: Add a new earthquake event
    private static void createEvent() {
        try {
            System.out.println("\n--- Create New Earthquake Event ---");
            String location = getStringInput("Enter location: ");
            double magnitude = getDoubleInput("Enter magnitude: ");
            if (magnitude <= 0 || magnitude > 10) {
                throw new InvalidMagnitudeException("Magnitude must be between 0.1 and 10.0");
            }
            LocalDate date = getDateInput("Enter date (YYYY-MM-DD): ");

            SeismicEvent event;
            if (magnitude < 4.0) {
                event = new MinorEarthquake(nextId++, location, magnitude, date);
            } else if (magnitude <= 6.0) {
                event = new ModerateEarthquake(nextId++, location, magnitude, date);
            } else {
                event = new MajorEarthquake(nextId++, location, magnitude, date);
            }

            events.add(event);
            System.out.println("Event created successfully!");
            event.displayEvent(); // Polymorphism: calls overridden getAlertMessage()
        } catch (InvalidMagnitudeException | DateTimeParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // READ: Display all events or search by ID
    private static void readEvents() {
        if (events.isEmpty()) {
            System.out.println("No events recorded.");
            return;
        }

        System.out.println("\n--- View Earthquake Events ---");
        System.out.println("1. View all events");
        System.out.println("2. Search by ID");
        int choice = getIntInput("Enter choice: ");

        if (choice == 1) {
            for (SeismicEvent event : events) {
                event.displayEvent(); // Polymorphism
                System.out.println();
            }
        } else if (choice == 2) {
            int id = getIntInput("Enter event ID: ");
            SeismicEvent event = findEventById(id);
            if (event != null) {
                event.displayEvent();
            } else {
                System.out.println("Event not found.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // UPDATE: Modify an existing event
    private static void updateEvent() {
        int id = getIntInput("Enter event ID to update: ");
        SeismicEvent event = findEventById(id);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        try {
            System.out.println("Current details:");
            event.displayEvent();

            String location = getStringInput("Enter new location (or press Enter to keep current): ");
            if (!location.isEmpty()) event.setLocation(location);

            double magnitude = getDoubleInput("Enter new magnitude (or 0 to keep current): ");
            if (magnitude != 0) {
                if (magnitude <= 0 || magnitude > 10) {
                    throw new InvalidMagnitudeException("Magnitude must be between 0.1 and 10.0");
                }
                event.setMagnitude(magnitude);
            }

            LocalDate date = getDateInput("Enter new date (YYYY-MM-DD, or press Enter to keep current): ");
            if (date != null) event.setDate(date);

            System.out.println("Event updated successfully!");
            event.displayEvent();
        } catch (InvalidMagnitudeException | DateTimeParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // DELETE: Remove an event by ID
    private static void deleteEvent() {
        int id = getIntInput("Enter event ID to delete: ");
        SeismicEvent event = findEventById(id);
        if (event != null) {
            events.remove(event);
            System.out.println("Event deleted successfully.");
        } else {
            System.out.println("Event not found.");
        }
    }

    // Helper: Find event by ID
    private static SeismicEvent findEventById(int id) {
        for (SeismicEvent event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    // Helper: Get integer input with exception handling
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Helper: Get double input with exception handling
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Helper: Get string input
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // Helper: Get date input with exception handling
    private static LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                if (input.isEmpty()) return null; // Allow keeping current
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Use YYYY-MM-DD.");
            }
        }
    }
}