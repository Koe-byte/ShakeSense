# ShakeSense: Earthquake Monitoring System

## Description
ShakeSense is a Java console-based program that simulates an earthquake monitoring system. It allows users to record earthquake data, classify seismic events by magnitude, and display corresponding alert messages. The program also handles invalid inputs through exception handling, ensuring reliability and smooth user interaction. By merging creativity with functionality, ShakeSense captures the essence of real-world systems through elegant OOP design.

This project demonstrates CRUD operations (Create, Read, Update, Delete) on earthquake events, with classification into Minor, Moderate, and Major earthquakes based on magnitude.

## OOP Concepts Applied
- **Encapsulation**: Fields in `SeismicEvent` are private, with public getters and setters to control access.
- **Inheritance**: `SeismicEvent` is the superclass, with subclasses `MinorEarthquake`, `ModerateEarthquake`, and `MajorEarthquake` inheriting properties and methods.
- **Polymorphism**: The `getAlertMessage()` method is overridden in subclasses, and dynamic behavior is shown by calling it via superclass references in the `ArrayList<SeismicEvent>`.
- **Abstraction**: `SeismicEvent` is an abstract class with an abstract method `getAlertMessage()`, hiding implementation details.
- **Exception Handling**: Custom `InvalidMagnitudeException` and try-catch blocks for input validation (e.g., invalid magnitudes, dates, or numbers).

## Project Structure
- `SeismicEvent.java`: Abstract superclass for seismic events.
- `MinorEarthquake.java`: Subclass for minor earthquakes (magnitude < 4.0).
- `ModerateEarthquake.java`: Subclass for moderate earthquakes (4.0–6.0).
- `MajorEarthquake.java`: Subclass for major earthquakes (>6.0).
- `InvalidMagnitudeException.java`: Custom exception for magnitude validation.
- `ShakeSense.java`: Main class with CRUD menu and user interactions.
- `README.md`: This documentation file.

## How to Run
1. Ensure you have Java installed (JDK 8 or higher).
2. Compile the files: `javac *.java`
3. Run the program: `java ShakeSense`
4. Follow the console menu to perform CRUD operations.

## Author
[Your Name] - [Your Student ID or Contact Info]
