import java.util.Scanner;

/**
 * Created by GaBi on 31.03.2016.
 */

public class Controller {
    private int randomTarget;
    private int guesses = 0;
    private boolean check = false;

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        randomTarget = model.rand(model.minBound,model.maxBound); // generate random number from minBound to maxBound

        while ( ! check ){ // while number is guessed, do
            guesses++; // increase counter
            Scanner sc = new Scanner(System.in); // initialize Scanner
            model.setValue(inputValuesWithScanner(sc, View.INPUT_INT_DATA, View.TO)); // scan input
            check = model.checkGuess(model.getValue(), randomTarget); // compare input and number
        }

        view.printMessageAndIntAndMessage(View.IT_TOOK_YOU, guesses, View.NUMBER_OF_GUESSING);
    }

    // The Utility methods
    public int inputValuesWithScanner(Scanner sc, String message1, String message2) {
        view.printMessageAndIntAndMessageAndInt(message1, model.minBound, message2, model.maxBound);

        while( ! sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT + message1 + model.minBound + message2 + model.maxBound);
            sc.next();
        }
        return sc.nextInt();
    }


}
