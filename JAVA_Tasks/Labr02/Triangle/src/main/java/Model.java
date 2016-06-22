/**
 * Created by GaBi on 31.03.2016.
 */
public class Model {
    private int sideValue;
    double semiPerimeter;

    // The Program logic

    /**
     * in this method counts perimeter of triangle
     * @param ( sideA,  sideB,  sideC )
     * @return semiPerimeter
     */
    public double countSemiPerimeter(int sideA, int sideB, int sideC){
        if (checkValuesForTriangle(sideA, sideB, sideC)) {
            return (sideA + sideB + sideC) / 2.0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * in this method counts square of triangle
     * @param ( sideA,  sideB,  sideC )
     * @return square
     */
    public double countSquare(int sideA, int sideB, int sideC){
        if (checkValuesForTriangle(sideA, sideB, sideC)) {
            semiPerimeter = countSemiPerimeter(sideA, sideB, sideC);
            return Math.round(Math.sqrt(semiPerimeter * (semiPerimeter - sideA) *
                    (semiPerimeter - sideB) * (semiPerimeter - sideC)) * 100) / 100.0;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * in this method check correctness of input values to build a triangle
     * @param ( sideA,  sideB,  sideC )
     * @return boolean true if values are correct or boolean false if values are incorrect
     */
    public boolean checkValuesForTriangle(int sideA, int sideB, int sideC){
        return ((sideA > 0) && (sideB > 0) && (sideC > 0)) &&
                ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA));
    }

    public int getValue() {
        return sideValue;
    }

    public void setValue(int sideValue) {
        this.sideValue = sideValue;
    }
}
