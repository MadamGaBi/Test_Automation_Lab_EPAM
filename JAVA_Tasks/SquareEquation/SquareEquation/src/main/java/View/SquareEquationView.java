package View;

/**
 * Created by GaBi on 10.04.2016.
 */
public class SquareEquationView {
    public static final String COEFFICIENT_A = "Coefficient A is ";
    public static final String COEFFICIENT_B = "Coefficient B is ";
    public static final String COEFFICIENT_C = "Coefficient C is ";
    public static final String RETURN_TWO_VALUES = "Method should return 2 values.";
    public static final String RETURN_ONE_VALUE = "Method should return 1 value.";
    public static final String WRONG_INPUT_DATA = "Wrong input! Repeat please!";
    public static final String SOLUTIONS_ARE = "Solutions of square equation are ";
    public static final String SOLUTION_IS = "The solution of square equation is ";
    public static final String NO_SOLUTION = "This equation does not have real roots.";
    public static final String AND = " and ";
    public static final String ANY_SOLUTION = "This equation has any solution.";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printMessageAndInt(String message, double value){
        System.out.println(message + value);
    }

    public void printMessageAndInts(String message1, double value1, String message2, double value2){
        System.out.println(message1 + value1 + message2 + value2);
    }
}
