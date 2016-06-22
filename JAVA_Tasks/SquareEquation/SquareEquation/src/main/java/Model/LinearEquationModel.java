package Model;

/**
 * Created by GaBi on 10.04.2016.
 */

public class LinearEquationModel extends SquareEquationModel {
    private double coefficientB;
    private double coefficientC;

    public LinearEquationModel() {
    }

    public LinearEquationModel(double coefficientB, double coefficientC) {
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public double getCoefficientC() {
        return coefficientC;
    }

    public void setCoefficientB(double coefficientB) {
        this.coefficientB = coefficientB;
    }

    public void setCoefficientC(double coefficientC) {
        this.coefficientC = coefficientC;
    }

    @Override
    public String toString() {
        return "" +
               coefficientB + " * x + " +
               coefficientC + " = 0";
    }

    @Override
    public double[] solve(){
        if (coefficientB == 0){
            throw new IllegalArgumentException();
        } else {
            return new double[] {(-coefficientC) / (coefficientB)};
        }
    }
}
