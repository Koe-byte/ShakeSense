<h1 align="center" style="font-size: 2.5em;">🌍 ShakeSense: Earthquake Monitoring System 🔔</h1>

## 📖 Description/Overview
ShakeSense is an exhilarating Java console-based program that brings the thrill of earthquake monitoring to your fingertips! 🚀 Designed to simulate a real-world seismic tracking system, it empowers users to record, classify, and manage earthquake data with ease. Key features include CRUD operations (Create, Read, Update, Delete) on events, automatic classification into Minor, Moderate, or Major earthquakes based on magnitude, and robust exception handling to dodge those pesky invalid inputs. This project solves the "chaos of unmanaged data" by providing a structured, interactive way to track seismic activity, all while showcasing elegant OOP design. Get ready to feel the rumble – safely, of course! 🌋

## 🛠️ OOP Concepts Applied
Dive into the heart of Object-Oriented Programming with ShakeSense – where code comes alive through these principles! Here's how we shook things up:

### 🔒 Encapsulation
We locked down our data like a fortress! In the `SeismicEvent` class, fields like `id`, `location`, `magnitude`, and `date` are private, accessible only through public getters and setters. This bundles data and operations together, preventing unauthorized meddling and keeping everything secure and modular. No sneaky access here! 🛡️

### 🏗️ Inheritance
Family reunion for classes! `SeismicEvent` serves as the abstract superclass, with `MinorEarthquake`, `ModerateEarthquake`, and `MajorEarthquake` as its eager subclasses. They inherit properties and methods, promoting code reusability – why reinvent the wheel when you can inherit it? This hierarchy allows for easy expansion, like adding new quake types without rewriting everything. 🌳

### 🎭 Polymorphism
One method, endless possibilities! The `getAlertMessage()` method is overridden in each subclass to deliver tailored alerts (e.g., "Minor rumble" vs. "Major evacuation!"). Dynamic behavior shines when we store subclasses in an `ArrayList<SeismicEvent>` and call the method – the right version pops up at runtime. It's like magic, but with code! ✨

### 🎨 Abstraction
Hide the nitty-gritty and focus on the big picture! `SeismicEvent` is an abstract class with an abstract `getAlertMessage()` method, forcing subclasses to implement it. This hides complex details, letting users interact with high-level operations without worrying about the internals. Abstraction at its finest – simple, clean, and powerful! 🖼️

### ⚠️ Exception Handling
No crashes allowed! We crafted a custom `InvalidMagnitudeException` and sprinkled try-catch blocks throughout for input validation (think invalid numbers or dates). This ensures smooth sailing, gracefully handling errors and keeping the user experience as steady as a seismograph. Safety first! 🚨

## 📂 Program Structure
ShakeSense is built like a well-oiled machine, with classes playing distinct roles in this seismic symphony. Here's the breakdown, complete with a text-based class diagram for that visual flair:

### Main Classes and Roles
- **`ShakeSense.java`**: The command center! This main class handles the console menu, user interactions, and orchestrates CRUD operations. It's the heart of the program, managing the event list and calling the shots.
- **`SeismicEvent.java`**: The abstract blueprint for all earthquakes. It defines common properties (id, location, magnitude, date) and the abstract `getAlertMessage()` method. Encapsulation and abstraction star here!
- **`MinorEarthquake.java`**: Subclass for quakes under 4.0 magnitude. Overrides `getAlertMessage()` with a chill vibe.
- **`ModerateEarthquake.java`**: Subclass for 4.0–6.0 quakes. Delivers a cautious alert.
- **`MajorEarthquake.java`**: Subclass for quakes over 6.0. Screams urgency!
- **`InvalidMagnitudeException.java`**: Custom exception class for handling magnitude mishaps. Keeps things error-free.

### Text-Based Class Diagram
```
SeismicEvent (Abstract)
├── id: int
├── location: String
├── magnitude: double
├── date: LocalDate
├── getAlertMessage(): String (abstract)
├── getters/setters
├── displayEvent(): void
│
├── MinorEarthquake
│   └── getAlertMessage(): "Minor earthquake detected. No significant impact expected."
│
├── ModerateEarthquake
│   └── getAlertMessage(): "Moderate earthquake detected. Possible minor damage; stay alert."
│
└── MajorEarthquake
    └── getAlertMessage(): "Major earthquake detected! Evacuate immediately and seek shelter."
```

Relationships: Inheritance flows from `SeismicEvent` to its subclasses. `ShakeSense` uses an `ArrayList<SeismicEvent>` for polymorphism, storing any subclass and calling overridden methods dynamically. Exception handling ties it all together for reliability!

## 🚀 How to Run the Program
Ready to unleash the quake tracker? Follow these epic steps to get ShakeSense rumbling on your machine:

1. **Gear Up**: Ensure Java JDK 8 or higher is installed. Check with `java -version` in your terminal. ☕
2. **Navigate**: Open your terminal and head to the project folder where your `.java` files live (e.g., `cd path/to/ShakeSense`).
3. **Compile**: Type `javac *.java` and hit enter. Watch the magic as Java compiles your code into `.class` files. 🔨
4. **Launch**: Run `java ShakeSense` to start the program. The console menu will greet you!
5. **Interact**: Choose options from the menu (1-5) to add, view, update, delete, or insert events. Follow prompts for location, magnitude, etc. When done, select 6 to exit. Easy peasy! 🎮

Pro Tip: If you encounter errors, double-check your Java path or ensure all files are in the same directory. Happy shaking!

## 📊 Sample Output
Here's a sneak peek at ShakeSense in action – imagine the console lighting up with earthquake excitement! Below is a simulated run (user inputs in bold for clarity):

```
Welcome to ShakeSense - Earthquake Monitoring System

--- ShakeSense Menu ---
1. Create Earthquake Event
2. Read/View Earthquake Events
3. Update Earthquake Event
4. Delete Earthquake Event
5. Exit
Enter your choice: 1
--- Create New Earthquake Event ---
Enter location: Tokyo
Enter magnitude: 5.2
Enter date (YYYY-MM-DD): 2023-10-15
Event created successfully!
ID: 1, Location: Tokyo, Magnitude: 5.2, Date: 2023-10-15
Alert: Moderate earthquake detected. Possible minor damage; stay alert.

Enter your choice: 2
--- View Earthquake Events ---
ID: 1, Location: Tokyo, Magnitude: 5.2, Date: 2023-10-15
Alert: Moderate earthquake detected. Possible minor damage; stay alert.

Enter your choice: 5
Exiting ShakeSense. Goodbye!
```

## 👤 Author 
**Authors**: Romelie, Nash, and Venice 

---

<small>*DISCLAIMER: This project is a creative learning tool. Use it as inspiration, not a direct copy – shake up your own version!* 😉</small>
