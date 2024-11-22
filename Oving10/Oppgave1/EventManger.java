
public class EventManger {

    static Event[] testEvents = new Event[] {
        new Event(0, "Love on air", "New York", "John Doe", "Concert", 200210301800L),
        new Event(1, "Tech Conference", "San Francisco", "Jane Smith", "Conference", 202310301800L),
        new Event(2, "Music Festival", "Los Angeles", "Alice Johnson", "Concert", 202410301800L),
        new Event(3, "Art Show", "New York", "Bob Brown", "Show", 202210301800L),
        new Event(4, "Startup Pitch", "San Francisco", "Charlie Davis", "Business", 202110301800L),
        new Event(5, "Wine Auction", "Chicago", "Emily White", "Auction", 202310301800L),
        new Event(6, "Food Carnival", "Houston", "Frank Green", "Carnival", 202210301800L),
        new Event(7, "Film Show", "Miami", "Grace Black", "Show", 202410301800L),
        new Event(8, "Charity Run", "Boston", "Hank Blue", "Sports", 202110301800L),
        new Event(9, "Science Expo", "Seattle", "Ivy Red", "Exhibition", 202310301800L),
        new Event(10, "Fashion Show", "Las Vegas", "Jack Yellow", "Show", 202210301800L),
        new Event(11, "Gaming Convention", "Orlando", "Karen Purple", "Convention", 202410301800L),
        new Event(12, "Wine Tasting", "Napa Valley", "Leo Orange", "Tasting", 202110301800L),
        new Event(13, "Art Auction", "New York", "Mona Pink", "Auction", 202310301800L),
        new Event(14, "Theater Play", "San Francisco", "Nina Gray", "Show", 202210301800L),
        new Event(15, "Dance Bootcamp", "Los Angeles", "Oscar Brown", "Workshop", 202410301800L),
        new Event(16, "Coding Bootcamp", "Chicago", "Paul White", "Workshop", 202110301800L),
        new Event(17, "Marathon", "Boston", "Quincy Green", "Sports", 202310301800L),
        new Event(18, "Jazz Night", "New Orleans", "Rachel Black", "Concert", 202210301800L),
        new Event(19, "Photography Exhibition", "Miami", "Sam Blue", "Exhibition", 202410301800L)
    };

    
    public static void main(String[] args) {

        EventRegister eventRegister = new EventRegister(testEvents);

        Event anotherEvent = new Event(20, "I hate air", "Boston", "John Doe", "Concert", 200210301900L);

        eventRegister.addEvent(anotherEvent);

        UserInterface eventMenu = new UserInterface(eventRegister);

        while (true) {
            eventMenu.getOption();
        }
        
    }

}