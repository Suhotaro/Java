import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class IteratorPattern {

    public void run()
    {
        /* Allows us to iterate through some collection */
        List<String> list = new LinkedList<String>();
        list.add("AAA");
        list.add("BBB");

        Iterator<String> it = list.iterator();
        while (it.hasNext())
        {
            String tmp = it.next();
            System.out.println(tmp);
        }
    }
}
