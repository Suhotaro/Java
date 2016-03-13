import sun.rmi.runtime.Log;

import java.util.HashMap;
import java.util.Map;

public class MultitonePattern {
    public void run() {
        Multitone multitone = new Multitone();
        ConfigSingleton config = (ConfigSingleton) multitone.get("config");
        LogSingleton log = (LogSingleton) multitone.get("log");
    }
}

class LogSingleton {
    private static LogSingleton log;

    private LogSingleton() {}

    public static LogSingleton getInstance () {
        if (log == null)
            log = new LogSingleton();

        return log;
    }
}

class Multitone {
    private Map<String, Object> map = new HashMap<String, Object>();

    public Multitone () {
        map.put("config", ConfigSingleton.getInstance());
        map.put("log", LogSingleton.getInstance());
    }

    public Object get(String name) {
        return map.get(name);
    }
}
