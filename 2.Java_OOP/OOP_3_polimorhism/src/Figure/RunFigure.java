package Figure;

public class RunFigure {

    public void run()
    {

        Figure figure = new Rectangle(3,4);
        System.out.println("Rectangle square: " + figure.getSquare());

        figure = new Triangle(1,2,3);
        System.out.println("Triangle square: " + (double)(int)(figure.getSquare()*100)/100);

        figure = new Circle(4);
        System.out.println("Circle square: " + figure.getSquare());
    }
}
