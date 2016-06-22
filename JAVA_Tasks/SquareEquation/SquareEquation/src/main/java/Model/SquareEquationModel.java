package Model;

/**
 * Created by GaBi on 10.04.2016.
 */

public class SquareEquationModel {
    private double coefficientA;
    private double coefficientB;
    private double coefficientC;

    public SquareEquationModel() {
    }

    public SquareEquationModel(double coefficientA, double coefficientB, double coefficientC) {
        this.coefficientA = coefficientA;
        this.coefficientB = coefficientB;
        this.coefficientC = coefficientC;
    }

    public double getCoefficientA() {
        return coefficientA;
    }

    public double getCoefficientB() {
        return coefficientB;
    }

    public double getCoefficientC() {
        return coefficientC;
    }

    public void setCoefficientA(double coefficientA) {
        this.coefficientA = coefficientA;
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
               coefficientA + " * x^2 +" +
               coefficientB + " * x + " +
               coefficientC + " = 0";
    }

    public double[] solve(){
        if ( coefficientA == 0){
            LinearEquationModel linearEquation = new LinearEquationModel();
            return linearEquation.solve();
        } else {
            double discriminant = coefficientB * coefficientB - 4 * coefficientA * coefficientC;
            if (discriminant > 0) {
                double x1 = (-coefficientB + Math.sqrt(discriminant)) / (2 * coefficientA);
                double x2 = (-coefficientB - Math.sqrt(discriminant)) / (2 * coefficientA);
                return new double[]{x1, x2};
            }else if (discriminant == 0) {
                double x = (-coefficientB) / (2 * coefficientA);
                return new double[]{x};
            } else
            return new double[]{};
        }
    }
}
