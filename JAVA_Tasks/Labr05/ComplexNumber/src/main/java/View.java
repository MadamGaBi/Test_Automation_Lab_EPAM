/**
 * Created by GaBi on 11.04.2016.
 */

public class View {
    // Text's constants
    public static final String INPUT_DOUBLE_DATA = "Input DOUBLE value. ";
    public static final String REAL_PART = "Real part of complex number = ";
    public static final String IMAGINARY_PART = "Imaginary part of complex number = ";
    public static final String WRONG_INPUT_DOUBLE_DATA = "Wrong input! Repeat please! ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, double value){
        System.out.println(message + value);
    }

}
