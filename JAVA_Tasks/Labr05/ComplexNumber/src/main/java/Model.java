/**
 * Created by GaBi on 11.04.2016.
 */

public class Model implements Cloneable {
    private double a;
    private double b;

    public Model() {
    }

    public Model(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (Double.compare(model.a, a) != 0) return false;
        return Double.compare(model.b, b) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Complex number " + a + "i + " + b + ", where i is the imaginary unit.";
    }

    @Override
    public Model clone() throws CloneNotSupportedException {
        try{
            Model temp = (Model)super.clone();
            return temp;
        }catch ( CloneNotSupportedException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // The Program logic

    /**
     * this method calculates the addition of two complex numbers
     * @param (a, b)(c, d)
     * @return addition
     */
    public String addition (double a, double b, double c, double d){
        double realPart = a + c;
        double imaginaryPart = b + d;
        return new Model(realPart, imaginaryPart).toString();
    }

    /**
     * this method calculates the subtraction of two complex numbers
     * @param (a, b)(c, d)
     * @return subtraction
     */
    public String subtraction (double a, double b, double c, double d){
        double realPart = a - c;
        double imaginaryPart = b - d;
        return new Model(realPart, imaginaryPart).toString();
    }

    /**
     * this method calculates the multiplication of two complex numbers
     * @param (a, b)(c, d)
     * @return multiplication
     */
    public String multiplication  (double a, double b, double c, double d){
        double realPart = a * c - b * d;
        double imaginaryPart = b * c + a * d;
        return new Model(realPart, imaginaryPart).toString();
    }

    /**
     * this method calculates the division of two complex numbers
     * @param (a, b)(c, d)
     * @return division
     */
    public String division  (double a, double b, double c, double d){
        double realPart = (a * c + b * d) / (c * c + d * d);
        double imaginaryPart = (b * c - a * d) / (c * c + d * d);
        return new Model(realPart, imaginaryPart).toString();
    }
}
