/**
 * Created by GaBi on 31.03.2016.
 */
public class View {
    // Text's constants
    public static final String INPUT_INT_DATA = "Please enter an integer number in the range ";
    public static final String TO = " to ";
    public static final String INPUT_INT_DATA_TOO_LARGE = "Your number is too large!";
    public static final String INPUT_INT_DATA_TOO_SMALL = "Your number is too small!";
    public static final String INPUT_INT_DATA_TRUE = "You got it! The number was ";
    public static final String IT_TOOK_YOU = "It took you ";
    public static final String NUMBER_OF_GUESSING = " guesses to get the number!";
    public static final String WRONG_INPUT = "You have not entered an integer number. ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, int value){
        System.out.println(message + value);
    }

    public void printMessageAndIntAndMessage(String message1, int value, String message2){
        System.out.println(message1 + value + message2);
    }

    public void printMessageAndIntAndMessageAndInt(String message1, int value1, String message2, int value2){
        System.out.println(message1 + value1 + message2 + value2);
    }
}
