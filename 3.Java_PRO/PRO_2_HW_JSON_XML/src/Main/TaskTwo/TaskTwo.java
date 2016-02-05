package Main.TaskTwo;


import com.sun.jmx.remote.internal.Unmarshal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskTwo {
    public static void run()
    {
        Trains trains = new Trains();
        /*
        trains.add(new Train("1", "AA", "BB", "1234", "6789"));
        trains.add(new Train("2", "AA", "BB", "1234", "6789"));
        */

        try
        {
            //File file = new File("D:\\MyPrj\\Java_main\\PRO_HW_JSON_XML\\out.xml");
            File file = new File("D:\\MyPrj\\Java_main\\PRO_HW_JSON_XML\\trains.xml");

            /*
            if ( ! file.exists())
                return;
            */

            JAXBContext jaxb_context = JAXBContext.newInstance(Trains.class);

            /*
            Marshaller marshaller = jaxb_context.createMarshaller();
            //Make output xml files readable for human
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(trains, file);
            marshaller.marshal(trains, System.out);
            */

            Unmarshaller unmarshaller = jaxb_context.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file);

            System.out.println(trains);

        }
        catch (JAXBException ex)
        {
            ex .getStackTrace();
        }
    }
}
