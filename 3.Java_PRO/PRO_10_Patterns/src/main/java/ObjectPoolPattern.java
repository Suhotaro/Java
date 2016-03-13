import java.util.ArrayList;
import java.util.List;

public class ObjectPoolPattern {
    public void run() {
        DBPool dbPool = new DBPool();

        String d = "data 1";
        dbPool.put(d);

        String d2 = "data 2";
        dbPool.put(d2);

        String d3 = dbPool.get();
        System.out.println(d3);
    }
}

class DBPool {
    List<String> pool = new ArrayList<String>();

    public synchronized String get() {
        if (pool.size() > 0) {
            String data = pool.get(pool.size() - 1);
            pool.remove(data);
            return data;
        }
        else
            return null;
    }

    public synchronized void put(String data) {
        pool.add(data);
    }
}