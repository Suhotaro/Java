package Figures;

public class RunFigure {

    public RunFigure() {;}

    public void run()
    {
        Rectangle r = new Rectangle(3,4);
        System.out.println("Rectangle square: " + r.getSquare());

        Triangle t = new Triangle(1,2,3);
        System.out.println("Trigram square: " + (double)(int)(t.getSquare()*100)/100);

        Circle c = new Circle(4);
        System.out.println("Circle square: " + c.getSquare());
    }
}
