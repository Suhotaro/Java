package FileCopy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileCopy {

    public void run()
    {
        FileContainer container = new FileContainer("D:\\tmp\\a.txt", "D:\\tmp\\b.txt", 3);
        container.process();
    }
}

class FileContainer {
    String in;
    String out;
    long size;
    long peace;
    int num_thread;

    public FileContainer (String in, String out, int num_thread) {
        this.in = in;
        this.out = out;
        this.num_thread = num_thread;

        File file = new File(in);
        size = file.length() / 3;
        peace = 0;

        if ( 0 != (file.length() % 3) )
            peace = (file.length() % 3);
    }

    public void process() {
        FileProcess []list = new FileProcess[num_thread];
        int start = 0;
        int offset = (int)size;

        for (int i = 0; i < num_thread; i++) {
            if (0 == i)
                list[i] = new FileProcess(start, size);
            else if ( i < num_thread - 1) {
                list[i] = new FileProcess(offset, size);
                offset += size;
            }
            else
                list[i] = new FileProcess(offset, size + peace);
        }

        for (int i = 0; i < num_thread; i++)
            list[i].start();

        for (int i = 0; i < num_thread; i++) {
            try
            {
                list[i].join();
            }
            catch (InterruptedException ex)
            {
                ex.getStackTrace();
            }
        }
    }

    class FileProcess extends Thread {

        int start = 0;
        long size = 0;

        public FileProcess (int start, long size)
        {
            this.start = start;
            this.size = size;
        }

        public void run () {

            int counter = 0;

            try {
                RandomAccessFile in = new RandomAccessFile(FileContainer.this.in, "rw");
                RandomAccessFile out = new RandomAccessFile(FileContainer.this.out, "rw");

                in.seek(start);
                out.seek(start);

                byte[] buf = new byte[(int)size];
                int r = 0;

                do {
                    r = in.read(buf, 0, buf.length);
                    if (r > 0) {
                        out.write(buf, 0, r);
                        counter += r;
                    }
                }
                while (r > 0 && counter < (int)size);

                System.out.println("Counter: " + counter);

                in.close();
                out.close();
            }
            catch (FileNotFoundException ex) {
                System.out.println("NO FILE" + ex.toString());
            }
            catch (IOException ex) {
                System.out.println("NO FILE" + ex.toString());
            }
        }
    }
}

