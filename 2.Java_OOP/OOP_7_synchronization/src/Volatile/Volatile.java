package Volatile;

public class Volatile extends Thread
{
    public void run()
    {
        volatileThread vt = new volatileThread();
        vt.start();

        try {
            Thread.sleep(2);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        vt.stopPlease();
    }
}

class volatileThread extends Thread {
    private volatile boolean stop;

    public void run()
    {
        System.out.println("START");

        while (!stop)
        {
            System.out.println("-");
        }
    }

    public void stopPlease()
    {
        System.out.println("STOP");
        stop = true;
    }
}
