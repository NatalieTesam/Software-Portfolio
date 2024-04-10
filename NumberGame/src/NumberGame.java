import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {

        // Creates the HighScores file to check if the new score is a record and to save the highest score reached.
        // If the file is already created, it will not do anything.
        try {
            File highScoreFile = new File("HighScores.txt");
            if (highScoreFile.createNewFile()) {
                System.out.println("File created: " + highScoreFile.getName());
            } else {
                System.out.println(highScoreFile.getName() + " exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Variables
        boolean keepPlaying = true;

        // The game loop. While keep playing is true, the game will restart and play as many times as desired
        while (keepPlaying) {
            HighScore score = new HighScore("HighScores.txt");

            // Starting dialogue
            System.out.println("Welcome to the number guessing game!");
            System.out.println("Please Guess a number between 1 and 100.");

            // Creates a new instance of the Number class. Which generates a random number between 1 and 100 when initialized.
            Number num = new Number();

            // Scanner is used to read user input into the console.
            Scanner input = new Scanner(System.in);

            // Tracks the number of guesses the user takes to find the number, the lower the better.
            int guesses = 0;

            // This is the main part of the game, the action of guessing until the number is found.
            // If the number value returned is 0, then the number is found. If it is either 1 or -1, it is
            // either too high or too low of a guess.
            int check = 1;
            while (check != 0) {
                check = num.Check(input.nextInt());
                guesses += 1;
            }

            // First reads the current scores to update the values, then checks and writes the new score if it is higher.
            score.ReadScore();
            score.WriteScore(guesses);

            // Finishing dialogue.
            System.out.println("Congratulations! You found the number " + num.GetNumber() + " in " + guesses + " guesses!");
            System.out.println("Do you want to play again? (yes/no): ");

            // Scanner to read the string input and compare with if they want to keep going or stop the game.
            Scanner answer = new Scanner(System.in);
            String response = answer.nextLine();
            if (Objects.equals(response, "no")){
                keepPlaying = false;

            }
        }
        // The game is now completely finished.
        System.out.println("Thank you for playing!");
    }
}
