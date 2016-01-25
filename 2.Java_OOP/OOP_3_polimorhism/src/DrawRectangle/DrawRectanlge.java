package DrawRectangle;


public class DrawRectanlge {

    private int width, height;

    DrawRectanlge(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw_rectangle ()
    {
        for (int i = 0; i <= height + 1; i++)
        {
            if ( 0 == i || (height + 1) == i)
                draw_full_line(width);
            else
                draw_middle(width);

            System.out.print('\n');
        }

    }

    protected void draw_full_line(int width)
    {
        System.out.print(' ');
        for (int i = 0; i < width; i ++)
            System.out.print('-');
    }

    protected void draw_middle(int width)
    {
        for (int i = 0; i <= width + 1; i ++)
        {
            if (0 == i || width + 1 == i)
                System.out.print('|');
            else
                System.out.print(' ');
        }
    }
}
