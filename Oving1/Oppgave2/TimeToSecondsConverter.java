
// This program converts hours, minutes and seconds to total seconds
public class TimeToSecondsConverter {
    // These are the constants used to convert hours and minutes to seconds
    private static final int seconds_per_minute = 60;
    private static final int minutes_per_hour = 60;

    // This function converts hours, minutes and seconds to total seconds
    public static int convertTime(int hours, int minutes, int seconds) {
        int totalSecondsPerHour = (hours * minutes_per_hour * seconds_per_minute);
        int totalSecondsPerMinute = (minutes * seconds_per_minute);
        int totalSeconds = (totalSecondsPerHour + totalSecondsPerMinute + seconds);
        return totalSeconds;
    }

    // This function prints the total seconds when passing hours, minutes and seconds as arguments
    private static void printTotalSeconds(int hours, int minutes, int seconds) {
        int totalSeconds = convertTime(hours, minutes, seconds);
        System.out.println(String.format("%s hours, %s minutes, %s seconds -> %s seconds", 
        hours, minutes, seconds, totalSeconds));
    }

    // This is the main function
    public static void main(String[] args) {
        // These are test samples to see if the program works
        printTotalSeconds(1, 20, 30);
        printTotalSeconds(0, 20, 40);
        printTotalSeconds(2, 0, 0);
        printTotalSeconds(3, 0, 10);
        printTotalSeconds(1, 0, 30);
    }
}