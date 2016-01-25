package Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunCar {

    public void run()
    {
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        try
        {
           s = d.readLine();
        }
        catch (IOException ex)
        {
            System.out.println("IO Exeption");
        }

        Car c = new Car();
        System.out.println(c.getName());

        if (s.equals("1"))
            c = new BMW();
        else if(s.equals("2"))
            c = new BMW_M();
        else
            c = new Porche();

        System.out.println(c.getName());
    }
}
