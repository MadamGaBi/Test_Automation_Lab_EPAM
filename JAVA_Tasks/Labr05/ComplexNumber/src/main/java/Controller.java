import java.util.Scanner;

/**
 * Created by GaBi on 11.04.2016.
 */

public class Controller {

    // The Regex
    // (double) 2.34
    public static final String REGEX_DOUBLE = "^[-+]?[0-9]+(\\.[0-9]+)?$";

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);
        model.setA(inputValueWithScanner(sc, REGEX_DOUBLE, View.REAL_PART));
        model.setB(inputValueWithScanner(sc, REGEX_DOUBLE, View.IMAGINARY_PART));

        view.printMessageAndInt(View.REAL_PART, model.getA());
        view.printMessageAndInt(View.IMAGINARY_PART, model.getB());

        view.printMessage(model.toString());
        // TODO: 12.04.2016 call methods with elementary operations for two complex numbers
    }

    // The Utility method
    public double inputValueWithScanner(Scanner sc, String regEx, String message) {
        boolean finished = false;
        String scanner = null;
        view.printMessage(View.INPUT_DOUBLE_DATA + message);
        while ( ! finished ) {
            scanner = sc.nextLine().trim();
            finished = scanner.matches(regEx);
            if (! finished) {
                view.printMessage(View.WRONG_INPUT_DOUBLE_DATA + message);
            }
        }
        return Double.parseDouble(scanner);
    }
}
