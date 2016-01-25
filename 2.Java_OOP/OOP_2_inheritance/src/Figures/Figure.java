package Figures;

import java.lang.Math;

public abstract class Figure {
    public abstract double getSquare();
}

class Rectangle extends Figure
{
    double width, heihgt;

    public Rectangle (double w, double h)
    {
        width = w;
        heihgt = h;
    }

    @Override
    public double getSquare() { return width * heihgt; }
}

class Triangle extends Figure
{
    double side_a, side_b, side_c;

    public Triangle (double side_a, double side_b, double side_c)
    {
        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;
    }


    /* Geron's method of calculation square of an trigram */
    @Override
    public double getSquare()
    {
        /* perimeter */
        double p = side_a + side_b + side_c;

        return Math.sqrt(p*(p - side_a)*(p - side_b)*(p - side_c));
    }
}

final class Circle extends Figure
{
    double radius;

    public Circle (double radius) { this.radius = radius; }

    @Override
    public double getSquare() { return 3.14*Math.pow(radius,2); }
}