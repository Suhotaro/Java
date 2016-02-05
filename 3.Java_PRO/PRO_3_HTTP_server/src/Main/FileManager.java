package Main;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

public class FileManager {
    private String path;
    private static ConcurrentHashMap<String, TimedCache> map = new ConcurrentHashMap<String, TimedCache>();

    public FileManager(String path) {
        // "c:\folder\" --> "c:\folder"
        if (path.endsWith("/") || path.endsWith("\\"))
            path = path.substring(0, path.length() - 1);

        System.out.println("FOLDER: " + path);

        this.path = path;
    }

    public byte[] get(String url) {
        try {

            TimedCache cache = map.get(url);

            if( cache != null)
            {
                if( cache.getTime() != 0 && cache.getTime() <= System.currentTimeMillis())
                {
                        return cache.getBuf();
                }
                else
                {
                    cache.setTime(-1);
                    cache.setBuf(null);
                }
            }

            byte []buf;

            // "c:\folder" + "/index.html" -> "c:/folder/index.html"
            String fullPath = path.replace('\\', '/') + url;

            RandomAccessFile f = new RandomAccessFile(fullPath, "r");
            try {
                buf = new byte[(int) f.length()];
                f.read(buf, 0, buf.length);
            } finally {
                f.close();
            }

            TimedCache tc = new TimedCache(System.currentTimeMillis() + 10, buf);
            map.put(url, tc);

            return buf;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
