package Figures;

import java.util.Arrays;

public class RunFigure {

    public RunFigure() {;}

    public void run() {
        Figure[] f = {
                new Rectangle(3, 4),
                new Triangle(1,2,3),
                new Circle(4),
    };
        System.out.println("Rectangle square: " + f[0].getSquare());
        System.out.println("Trigram square: " + (double)(int)(f[1].getSquare()*100)/100);
        System.out.println("Circle square: " + f[2].getSquare());

        Arrays.sort(f, new FigureComparator());

        for (Figure h : f)
            System.out.println(h.getSquare());
    }
}
