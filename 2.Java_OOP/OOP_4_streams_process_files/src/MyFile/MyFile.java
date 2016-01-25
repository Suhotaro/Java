package MyFile;


import java.io.File;
import java.io.IOException;

public class MyFile {

    public void run()
    {
        File file = new File("D:\\tmp");
        int num = 0;

        File[] list = file.listFiles();
        String [] files = file.list();

        for (String s : files)
            System.out.print( ++num + ": " + s + "\n");

        for (File t : list) {
            try {
                System.out.print(++num + ": " + t.getCanonicalPath() + "\n");
            }
            catch (IOException ex)
            {
                System.out.print("IO Error\n");
            }

        }

        File file2 = new File("D:\\tmp\\a.txt");
        System.out.print("File size :" + file2.length() + "\n");

    }
}
