package Controller;

/**
 * Created by GaBi on 10.04.2016.
 */

import java.util.Scanner;

import Model.LinearEquationModel;
import View.SquareEquationView;
import Model.SquareEquationModel;

public class SquareEquationController {
    public static final double EPSILON = 0.0000000001;

    // Constructor
    SquareEquationModel model;
    SquareEquationView view;

    public SquareEquationController(SquareEquationModel model, SquareEquationView view) {
        this.model  = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        double coefficientA = scanCoefficientA(SquareEquationView.COEFFICIENT_A);
        double coefficientB = scanCoefficientB(SquareEquationView.COEFFICIENT_B);
        double coefficientC = scanCoefficientC(SquareEquationView.COEFFICIENT_C);
        if (coefficientA != 0){
            callSolveSquareEquation(coefficientA,  coefficientB,  coefficientC);
        } else if (coefficientB != 0){
            callSolveLinearEquation(coefficientB,  coefficientC);
        } else if (coefficientC == 0){
            view.printMessage(SquareEquationView.ANY_SOLUTION);
        } else {
            view.printMessage(SquareEquationView.NO_SOLUTION);
        }
    }

    // The work method to call solving of square equation
    public void callSolveSquareEquation(double coefficientA, double coefficientB, double coefficientC){
        SquareEquationModel model = new SquareEquationModel(coefficientA, coefficientB, coefficientC);
        if (model.solve().length == 2) {
            view.printMessageAndInts(SquareEquationView.SOLUTIONS_ARE, model.solve()[0],
                                     SquareEquationView.AND, model.solve()[1]);
        } else if (model.solve().length == 1){
            view.printMessageAndInt(SquareEquationView.SOLUTION_IS, model.solve()[0]);
        } else {
            view.printMessage(SquareEquationView.NO_SOLUTION);
        }
    }

    // The work method to call solving of linear equation
    public void callSolveLinearEquation(double coefficientB, double coefficientC){
        SquareEquationModel model = new LinearEquationModel(coefficientB, coefficientC);
        if (model.solve().length == 1){
            view.printMessageAndInt(SquareEquationView.SOLUTION_IS, model.solve()[0]);
        } else {
            view.printMessage(SquareEquationView.NO_SOLUTION);
        }
    }

    // The Utility methods to scans input value in console
    public int inputValuesWithScanner(Scanner sc, String message) {
        view.printMessage(message);

        while( ! sc.hasNextInt()) {
            view.printMessage(SquareEquationView.WRONG_INPUT_DATA + message);
            sc.next();
        }
        return sc.nextInt();
    }

    public double scanCoefficientA(String message){
        Scanner sc = new Scanner(System.in);
        model.setCoefficientA(inputValuesWithScanner(sc, message));
        return model.getCoefficientA();
    }
    public double scanCoefficientB(String message){
        Scanner sc = new Scanner(System.in);
        model.setCoefficientB(inputValuesWithScanner(sc, message));
        return model.getCoefficientB();
    }
    public double scanCoefficientC(String message){
        Scanner sc = new Scanner(System.in);
        model.setCoefficientC(inputValuesWithScanner(sc, message));
        return model.getCoefficientC();
    }

}
