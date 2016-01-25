package DrawRectangle;


public class RunDrawRectangle {

    public void run()
    {
        DrawRectanlge rect = new DrawRectanlge(4,4);
        rect.draw_rectangle();

        System.out.println("\n\n2:");

        rect = new DrawRectanlge(2,2);
        rect.draw_rectangle();

        System.out.println("\n\n3:");

        rect = new DrawRectanlge(3, 5);
        rect.draw_rectangle();
    }
}

