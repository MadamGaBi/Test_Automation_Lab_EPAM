import java.util.Random;

/**
 * Created by GaBi on 31.03.2016.
 */

public class Model {
    private int value;
    int target;
    int minBound = 0;
    int maxBound = 100;

    // Constructor
    View view;

    public Model(View view) {
        this.view = view;
    }

    // The Program logic

    /**
     * this method generates random int value in [min, max] interval
     * @param min, max
     * @return target
     */
    public int rand ( int min, int max ){
        Random randomSet = new Random();
        target = randomSet.nextInt(max) + min;
        view.printMessageAndInt("A number ", target); // print number for easy debugging
    return target;
    }

    /**
     * this method compares guessInput and target value, and decreases [min, max] interval with relevant guessInputs
     * @param guessInput, target
     * @return boolean true, if the number was guessed, or boolean false, if the number was not guessed
     */
    public boolean checkGuess(int guessInput, int target){
        if ((guessInput < minBound) || (guessInput > maxBound)) {
            return false;
        }
        if (guessInput > target) {
            maxBound = guessInput;
            view.printMessage(View.INPUT_INT_DATA_TOO_LARGE);
            return false;
        }
        if (guessInput < target) {
            minBound = guessInput;
            view.printMessage(View.INPUT_INT_DATA_TOO_SMALL);
            return false;
        }
        if (guessInput == target) {
            view.printMessageAndInt(View.INPUT_INT_DATA_TRUE, target);
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
