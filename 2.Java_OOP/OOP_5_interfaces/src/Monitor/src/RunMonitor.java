package Monitor.src;

public class RunMonitor {
    public static void run() {


        /*
        Monitor m = new Monitor("D:\\tmp\\1.txt", new FileEvent());
        m.start();
        */

        /* Task 5.4 */
        /*
        Monitor m2 = new Monitor("D:\\tmp\\1.txt&D:\\tmp\\2.txt", new FileEvent());
        m2.start_more_then_one();
        */


        /* Task 5.5 */
        MonitorDir md = new MonitorDir("D:\\tmp\\tmp", new DirEvent());
        md.start();
    }
}

