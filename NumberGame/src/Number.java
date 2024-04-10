
import java.util.Random;

// This is the number class used to keep track of the number used in the game and compare it.
public class Number {
    private int num;

    // Initializes the number class by creating the random number between 1 and 100.
    public Number() {
        Random rand = new Random();
        this.num = rand.nextInt(101);
    }

    // Since the num variable is private, a getter is needed in order to get the value outside the class.
    public int GetNumber() {
        return this.num;
    }

    // This is where the comparison is made to see if the number is equal, higher, or lower than the guess.
    // It returns a value similar to icomparable values and informs the user if the number is higher or lower.
    public int Check(int guess) {
        if (guess == num) {
            return 0;
        }
        if (guess > num) {
            System.out.println("Lower");
            return 1;
        }
        else {
            System.out.println("Higher");
            return -1;
        }
    }
}
