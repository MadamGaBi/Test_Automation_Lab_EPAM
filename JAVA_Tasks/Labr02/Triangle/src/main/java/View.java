/**
 * Created by GaBi on 31.03.2016.
 */
public class View {
    // Text's constants
    public static final String INPUT_INT_DATA_OF_SIDE_A = "Input INT value of side A of triangle = ";
    public static final String INPUT_INT_DATA_OF_SIDE_B = "Input INT value of side B of triangle = ";
    public static final String INPUT_INT_DATA_OF_SIDE_C = "Input INT value of side C of triangle = ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! Repeat please! ";
    public static final String INPUT_DATA_CANT_MAKE_TRIANGLE = "Input side lengths can't make a triangle " +
                                                                "or you entered incorrect values! Try again!";
    public static final String SQUARE_VALUE = "Square of triangle equals ";
    public static final String SEMI_PERIMETER_VALUE = "Semi-perimeter of triangle equals ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, double value){
        System.out.println(message + value);
    }
}
