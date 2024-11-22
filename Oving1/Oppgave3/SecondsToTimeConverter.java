
// This program converts total seconds to hours, minutes and seconds
public class SecondsToTimeConverter {
    // This is a class to store hours, minutes and seconds
    public static class Time {
        public int hours;
        public int minutes;
        public int seconds;

        // This is the constructor of the class Time
        public Time(int hours, int minutes, int seconds) {
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }
    }

    // This function converts total seconds to time (hours, minutes and seconds)
    public static Time convertSecondsToTime(int totalSeconds) {
        int hours = totalSeconds / 3600;
        int remainingSeconds = totalSeconds % 3600;
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;
        return new Time(hours, minutes, seconds);
    }

    // This function prints total seconds to hours, minutes and seconds
    public static void printSecondsToTime(int totalSeconds) {
        Time time = convertSecondsToTime(totalSeconds);
        System.out.println(String.format("%s seconds -> %s hours, %s minutes, %s seconds", 
        totalSeconds, time.hours, time.minutes, time.seconds));
    }

    // This is the main function
    public static void main(String[] args) {
        // These are test samples to see if the program works
        printSecondsToTime(3819);
        printSecondsToTime(3638);
        printSecondsToTime(1848);
        printSecondsToTime(1930);
        printSecondsToTime(39);
        printSecondsToTime(489);
    }
}