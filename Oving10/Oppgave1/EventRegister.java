import java.util.Arrays;
import java.util.Comparator;

public class EventRegister {
    Event[] events;
    int eventCount;

    public EventRegister(Event[] events) {
        this.events = events;
        this.eventCount = events.length;
    }

    public void addEvent(Event event) {
        Event[] newEvents = new Event[events.length + 1];
        System.arraycopy(events, 0, newEvents, 0, events.length);
        newEvents[eventCount] = event;
        events = newEvents;
        eventCount++;
    }

    public Event getEventWithNumber(int number) {
        for (int i = 0; i < eventCount; i++) {
            if (events[i].number == number) {
                return events[i];
            }
        }
        return null;
    }

    public Event[] getEventsAtLocation(String location) {
        Event[] eventsAtLocation = new Event[eventCount];
        int count = 0;
        for (int i = 0; i < eventCount; i++) {
            if (events[i].location.equals(location)) {
                eventsAtLocation[count] = events[i];
                count++;
            }
        }
        return eventsAtLocation;
    }

    public Event[] getEventsAtDate(long date) {
        Event[] eventsAtDate = new Event[eventCount];
        int count = 0;
        for (int i = 0; i < eventCount; i++) {
            if (events[i].date / 10000 == date) {
                eventsAtDate[count] = events[i];
                count++;
            }
        }
        return eventsAtDate;
    }

    public Event[] getEventsBetweenDates(long date1, long date2) {
        Event[] eventsBetweenDates = new Event[eventCount];
        int count = 0;
        for (int i = 0; i < eventCount; i++) {
            // Since time is included in the date, we only compare the first 8 digits by removing the last 4 digits
            if (events[i].date / 10000 >= date1 && events[i].date / 10000 <= date2) {
                eventsBetweenDates[count] = events[i];
                count++;
            }
        }
        return eventsBetweenDates;
    }

    public Event[] sortEventsByDate() {
        Event[] sortedEvents = events.clone();
        if (eventCount == 0) {
            return sortedEvents;
        }

        Arrays.sort(sortedEvents, 0, eventCount, Comparator.comparing(event -> event.date / 10000));

        return sortedEvents;
    }

    public Event[] sortEventsByLocation() {
        Event[] sortedEvents = events.clone();
        if (eventCount == 0) {
            return sortedEvents;
        }

        Arrays.sort(sortedEvents, 0, eventCount, Comparator.comparing(event -> event.location));

        return sortedEvents;
    }

    public Event[] sortEventsByType() {
        Event[] sortedEvents = events.clone();
        if (eventCount == 0) {
            return sortedEvents;
        }

        Arrays.sort(sortedEvents, 0, eventCount, Comparator.comparing(event -> event.type));

        return sortedEvents;
    }

    public Event[] sortEventsByLocationTypeAndDate() {
        Event[] sortedEvents = events.clone();
        if (eventCount == 0) {
            return sortedEvents;
        }
        
        // Sort by location, then type, then date
        Arrays.sort(sortedEvents, 0, eventCount, Comparator
            .comparing((Event event) -> event.location)
            .thenComparing(event -> event.type)
            .thenComparingLong(event -> event.date));

        return sortedEvents;
    }

}
