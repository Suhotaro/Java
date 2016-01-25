package MyThreads;

import java.io.*;

public class FilePercentage {

    public  void run()
    {
        File in = new File("D:\\tmp\\tmp\\AA.txt");
        File out = new File("D:\\tmp\\tmp\\CC.txt");

        long size = in.length();
        double percentage = 0;

        System.out.println("Size of file: " + size);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(in));
            String line;

            int i = 0;

            while ((line = br.readLine()) != null)
            {
                Thread.sleep(1000);

                ++i;
                percentage += (double)((line.length() + 2) * 100) / size;
                if (percentage > 100)
                    percentage = 100;

                System.out.println("Copy " + percentage + "%" );

                System.out.println(line);
            }



        }
        catch (InterruptedException ex)
        {
            System.out.println("Inrerrupt " + ex.getStackTrace());
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File Not Found " + ex.getStackTrace());
        }
        catch (IOException ex)
        {
            System.out.println("IO Exeption " + ex.getStackTrace());
        }
        finally {

        }
    }
}
