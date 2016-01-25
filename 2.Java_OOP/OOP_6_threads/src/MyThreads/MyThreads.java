package MyThreads;

import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreads {

    private void runCounter() {
        try{
            Counter c = new Counter();
            c.start();

            Thread.sleep(5000);

            c.interrupt();
        }
        catch (InterruptedException ex)
        {
            System.out.println("Main interrupt");
            return;
        }
    }

    public void runTime() {

        try {
            threadTime time =  new threadTime();
            time.start();

            Thread.sleep(5000);

            time.interrupt();
        }
        catch (InterruptedException ex)
        {
            System.out.println("Main interrupt");
            return;
        }
    }

    public void runThousend() {

        int num_threads = 100;

        try {
            Thousend[] t =  new Thousend[num_threads];

            for(int i = 0; i < num_threads; i++)
                t[i] = new Thousend();

            for(int i = 0; i < num_threads; i++)
                t[i].start();

            Thread.sleep(5000);

            for(int i = 0; i < num_threads; i++)
                t[i].interrupt();
        }
        catch (InterruptedException ex)
        {
            System.out.println("Main interrupt");
            return;
        }
    }

    public void runFifty() {


        try {
            lord l = new lord();
            l.start();

            Thread.sleep(8000);

            l.interrupt();
        }
        catch ( InterruptedException ex  )
        {
            System.out.println("Main interrupt");
        }
    }


    public void run()
    {
        //runCounter();

        //runTime();

        //runThousend();

        runFifty();
    }
}


class Counter extends Thread{
    public void run() {
        int[] x = {1 ,2, 3 };
        int i = 0;

        while (!isInterrupted()){
            System.out.println(getId() + ":" + x[(i++) %3]);

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex)
            {
                System.out.println("Thread interrupt: " + getId());
                return;
            }
        }
    }
}

class threadTime extends Thread{
    public void run() {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        while (!isInterrupted()){
            System.out.println(getId() + "-" + sdf.format(System.currentTimeMillis()));

            try {
                Thread.sleep(500);
            }
            catch (InterruptedException ex)
            {
                System.out.println("Thread interrupt: " + getId());
                return;
            }
        }
    }
}

class Thousend extends Thread{
    public void run() {

        while (!isInterrupted()){
            System.out.println(getId());

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex)
            {
                System.out.println("Thread interrupt: " + getId());
                return;
            }
        }
    }
}

class lord extends Thread{
    public void run() {
        int num_threads = 50;

        try {
            Thousend[] t =  new Thousend[num_threads];

            for(int i = 0; i < num_threads; i++)
                t[i] = new Thousend();

            for(int i = 0; i < num_threads; i++)
                t[i].start();

            Thread.sleep(5000);

            for(int i = 0; i < num_threads; i++)
                t[i].interrupt();

            System.out.println("LORD interrupt");
        }
        catch (InterruptedException ex)
        {
            System.out.println("LORD interrupt");
            return;
        }
    }
}

