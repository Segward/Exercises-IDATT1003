import java.util.Scanner;

public class UserInterface {

    EventRegister eventRegister;
    Scanner scanner;

    public UserInterface(EventRegister eventRegister) {
        this.eventRegister = eventRegister;
        this.scanner = new Scanner(System.in);
    }

    public void getOption() {
        System.out.println("\n1. Get event with number");
        System.out.println("2. Get events at location");
        System.out.println("3. Get events at date");
        System.out.println("4. Get events between dates");
        System.out.println("5. Sort events by date");
        System.out.println("6. Sort events by location");
        System.out.println("7. Sort events by type");
        System.out.println("8. Sort events by location, type and date");
        System.out.println("9. Exit");
        System.out.println("10. Add event");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                System.out.print("Enter event number: ");
                int number = scanner.nextInt();
                Event event = eventRegister.getEventWithNumber(number);
                System.err.println("\n");
                System.out.println(event);
                return;
            case 2:
                System.out.print("Enter location: ");
                String location = scanner.nextLine();
                Event[] eventsAtLocation = eventRegister.getEventsAtLocation(location);
                System.err.println("\n");
                for (Event e : eventsAtLocation) {
                    if (e != null) {
                        System.out.println(e + "\n");
                    }
                }
                return;
            case 3:
                System.out.print("Enter date (YYYYMMDD): ");
                long date = scanner.nextLong();
                Event[] eventsAtDate = eventRegister.getEventsAtDate(date);
                System.err.println("\n");
                for (Event e : eventsAtDate) {
                    if (e != null) {
                        System.out.println(e + "\n");
                    }
                }
                return;
            case 4:
                System.out.print("Enter start date (YYYYMMDD): ");
                long startDate = scanner.nextLong();
                System.out.print("Enter end date (YYYYMMDD): ");
                long endDate = scanner.nextLong();
                Event[] eventsBetweenDates = eventRegister.getEventsBetweenDates(startDate, endDate);
                System.err.println("\n");
                for (Event e : eventsBetweenDates) {
                    if (e != null) {
                        System.out.println(e + "\n");
                    }
                }
                return;
            case 5:
                Event[] sortedEventsByDate = eventRegister.sortEventsByDate();
                System.err.println("\n");
                for (Event e : sortedEventsByDate) {
                    if (e != null) {
                        System.out.println(e + "\n");
                    }
                }
                return;
            case 6:
                Event[] sortedEventsByLocation = eventRegister.sortEventsByLocation();
                System.err.println("\n");
                for (Event e : sortedEventsByLocation) {
                    if (e != null) {
                        System.out.println(e + "\n");
                    }
                }
                return;
            case 7:
                Event[] sortedEventsByType = eventRegister.sortEventsByType();
                System.err.println("\n");
                for (Event e : sortedEventsByType) {
                    if (e != null) {
                        System.out.println(e + "\n");
                    }
                }
                return;
            case 8:
                Event[] sortedEventsByLocationTypeAndDate = eventRegister.sortEventsByLocationTypeAndDate();
                System.err.println("\n");
                for (Event e : sortedEventsByLocationTypeAndDate) {
                    if (e != null) {
                        System.out.println(e + "\n");
                    }
                }
                return;
            case 9:
                System.out.println("\nExiting...");
                System.exit(0);

            case 10:
                System.out.print("Enter event number: ");
                int eventNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter event name: ");
                String eventName = scanner.nextLine();
                System.out.print("Enter location: ");
                String eventLocation = scanner.nextLine();
                System.out.print("Enter host: ");
                String eventHost = scanner.nextLine();
                System.out.print("Enter type: ");
                String eventType = scanner.nextLine();
                System.out.print("Enter date (YYYYMMDDHHMM): ");
                long eventDate = scanner.nextLong();
                Event newEvent = new Event(eventNumber, eventName, eventLocation, eventHost, eventType, eventDate);
                eventRegister.addEvent(newEvent);
                System.err.println("\n");
                System.out.println("Event added successfully.");
                return;

            default:
                System.out.println("\nInvalid option. Please try again.");
                return;
        }
    }
}
