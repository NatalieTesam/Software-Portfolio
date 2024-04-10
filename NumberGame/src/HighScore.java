import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// This class is used for reading and writing the high scores to a file. It also checks if the score is higher.
public class HighScore {
    private int score;
    private String file;

    public HighScore(String filename) {
        this.file = filename;
        this.score = Integer.MAX_VALUE;
    }

    // Reads the file and compares the old high scores to see which is the smallest of the high scores.
    public int ReadScore() {
        try {
            File scores = new File(this.file);
            Scanner reader = new Scanner(scores);
            while (reader.hasNextInt()) {
                int data = reader.nextInt();
                if (data < score){
                    score = data;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return score;
    }

    // Writes the new score to the file if newScore is less than the last record.
    public void WriteScore(int newScore) {
        if (newScore < score) {
            try {
                FileWriter myWriter = new FileWriter(file);
                myWriter.write(newScore);
                myWriter.close();
                System.out.println("New high score recorded of " + newScore + "!");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Try to beat the high score of " + score + ".");
        }
    }
}
