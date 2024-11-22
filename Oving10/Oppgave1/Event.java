public class Event {
    int number;
    String name;
    String location;
    String host;
    String type;
    long date;

    public Event(int number, String name, String location, String host, String type, long date) {
        this.number = number;
        this.name = name;
        this.location = location;
        this.host = host;
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event number: " + number + "\nEvent name: " + name + "\nLocation: " + location + "\nHost: " + host + "\nType: " + type + "\nDate: " + date;
    }
}
