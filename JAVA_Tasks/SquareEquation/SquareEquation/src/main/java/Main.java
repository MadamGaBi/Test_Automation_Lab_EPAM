/**
 * Created by GaBi on 10.04.2016.
 */

import View.SquareEquationView;
import Model.SquareEquationModel;
import Controller.SquareEquationController;

public class Main {
    public static void main(String[] args) {
        // Initialization
        SquareEquationModel model = new SquareEquationModel();
        SquareEquationView view = new SquareEquationView();
        SquareEquationController controller = new SquareEquationController(model, view);
        // Run
        controller.processUser();
    }
}
