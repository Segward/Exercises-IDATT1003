import java.util.Random;

// The task is to create a game where two players roll a dice and the first to reach 100 wins
public class HundredGame {
    static final int MAX_DICE_VALUE = 6;
    static final int MIN_DICE_VALUE = 1;
    static final int WINNING_SCORE = 100;
    static Random terning = new Random();

    // This class represents a player in the game
    public static class Player {
        private int score;
        private String name;

        // Constructor for player
        public Player(String name) {
            this.score = 0;
            this.name = name;
        }

        // Roll the dice and update the score
        public void rollDice() {
            // Roll dice from 0 to 5 then add 1 to get 1 to 6
            int dice = terning.nextInt(MAX_DICE_VALUE) + MIN_DICE_VALUE;
            System.out.println("Dice: " + dice);
            // If dice is 1, reset score to 0
            if (dice == MIN_DICE_VALUE) {
                this.score = 0;
            // If the score is 100 or more, subtract the dice from the score
            } else if (this.score >= WINNING_SCORE) {
                this.score -= dice;
            // Otherwise add the dice to the score
            } else {
                this.score += dice;
            }
        }

        // If the score is 100 the player has won
        public boolean hasWon() {
            return this.score == WINNING_SCORE;
        }

        // Get the score of the player
        public int getScore() {
            return this.score;
        }

        // Get the name of the player
        public String getName() {
            return this.name;
        }
    }
    
    // This is the main method
    public static void main(String[] args) {
        // Create two players
        Player playerA = new Player("A");
        Player playerB = new Player("B");

        // Simulate the game
        while (true) {

            // Player A rolls dice
            playerA.rollDice();
            System.out.println(String.format("Player %s score: %s", playerA.getName(), playerA.getScore()));

            // If player A has won, print the winner and break the loop
            if (playerA.hasWon()) {
                System.out.println(String.format("\nPlayer %s has won!\n", playerA.getName()));
                break;
            }

            // Player A rolls dice
            playerB.rollDice();
            System.out.println(String.format("Player %s score: %s", playerB.getName(), playerB.getScore()));

            // If player B has won, print the winner and break the loop
            if (playerB.hasWon()) {
                System.out.println(String.format("\nPlayer %s has won!\n", playerB.getName()));
                break;
            }

        }
    }
}
