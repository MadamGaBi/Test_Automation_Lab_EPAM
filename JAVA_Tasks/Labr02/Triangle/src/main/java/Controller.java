import java.util.Scanner;

/**
 * Created by GaBi on 31.03.2016.
 */
public class Controller {

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        int[] sides = inputSidesForTriangle();
        view.printMessageAndInt(View.SEMI_PERIMETER_VALUE, model.countSemiPerimeter(sides[0],  sides[1],  sides[2]));
        view.printMessageAndInt(View.SQUARE_VALUE, model.countSquare(sides[0],  sides[1],  sides[2]));
    }

    // The Utility methods to scans input value in console
    public int inputValuesWithScanner(Scanner sc, String message) {
        view.printMessage(message);

        while( ! sc.hasNextInt()) {
            view.printMessage(View.WRONG_INPUT_INT_DATA + message);
            sc.next();
        }
        return sc.nextInt();
    }

    public int scanValue( String message){
        Scanner sc = new Scanner(System.in);
        model.setValue(inputValuesWithScanner(sc, message));
        return model.getValue();
    }

    public int[] inputSidesForTriangle(){
        int[] sides;
        boolean check = false;

        do{
            int sideA = scanValue(View.INPUT_INT_DATA_OF_SIDE_A);
            int sideB = scanValue(View.INPUT_INT_DATA_OF_SIDE_B);
            int sideC = scanValue(View.INPUT_INT_DATA_OF_SIDE_C);

            if (model.checkValuesForTriangle(sideA, sideB, sideC)){
                check = true;
            } else {
                view.printMessage(View.INPUT_DATA_CANT_MAKE_TRIANGLE);
            }
                sides = new int[]{sideA, sideB, sideC};
        } while ( ! check );

        return sides;
    }

}
