package ua.kpi.tef;

/**
 * Created by User on 07.04.2016.
 * Modified by GaBi on 12.04.2016
 */

public class Circle extends Shape {
    private Point centerCircle;
    private double radius;

    public Circle(Point centerCircle, double radius) {
        this.centerCircle = centerCircle;
        try {
            checkRadius(radius);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Circle(double x, double y, double radius) {
        this.centerCircle = new Point(x, y);
        try {
            checkRadius(radius);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkRadius(double radius) throws Exception {
        if( radius <= 0 ){
            throw new Exception("radius must be greater then 0");
        }
        this.radius = radius;
    }

    @Override
    public void move(double dx, double dy) {
        centerCircle.setX( centerCircle.getX() + dx);
        centerCircle.setY( centerCircle.getY() + dy);
    }

    @Override
    public double square() {
        return 3.14*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*3.14*radius;
    }

    public Point getCenterCircle() {
        return centerCircle;
    }

    public void setCenterCircle(Point centerCircle) {
        this.centerCircle = centerCircle;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws Exception {
        checkRadius(radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerCircle=" + centerCircle +
                ", radius=" + radius +
                '}';
    }
}
