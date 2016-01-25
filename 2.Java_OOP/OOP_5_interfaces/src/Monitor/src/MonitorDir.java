package Monitor.src;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;

public class MonitorDir {
    String file;
    IFileEvent event;
    int num_files;

    public MonitorDir(String file, IFileEvent event) {
        this.file = file;
        this.event = event;
    }

    public void start() {
        while (true) {

            File dir = new File(file);
            File[] files = dir.listFiles();


            for ( File f : files )
            {
                if (f.exists() && f.isFile()) {
                    if (event != null)
                        event.onFileAdded(f.getName());

                }

                ++num_files;
            }



            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}
