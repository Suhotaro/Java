package Main.TaskTwo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name="trains")
public class Trains {

    @XmlElement(name="train")
    private List<Train> trains = new ArrayList<Train>();

    public void add(Train train) {trains.add(train);}

    @Override
    public String toString() {return Arrays.deepToString(trains.toArray());}
}
