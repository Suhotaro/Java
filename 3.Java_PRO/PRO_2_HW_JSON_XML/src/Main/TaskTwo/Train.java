package Main.TaskTwo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="train")
@XmlType(propOrder={"from", "to", "date", "departure"})
public class Train {
    private String number;
    private String from;
    private String to;
    private String date;
    private String departure;

    public Train() {}

    public Train(String number, String from, String to, String date, String departure)
    {
        this.number = number;
        this.from = from;
        this.to = to;
        this.date = date;
        this.departure = departure;
    }

    @Override
    public String toString() {
        return "[" + number + ", " + from + ", " + to + ", " + date + ", " + departure + "]";
    }

    @XmlAttribute(name="id")
    public void setNumber(String from) { this.number = number; }
    public String getNumber() {return this.number; }

    @XmlElement
    public void setFrom(String from) { this.from = from; }
    public String getFrom() {return this.from; }

    @XmlElement
    public void setTo(String to) { this.to = to; }
    public String getTo() {return this.to; }

    @XmlElement
    public void setDate(String date) { this.date = date; }
    public String getDate() {return this.date; }

    @XmlElement
    public void setDeparture(String departure) { this.departure = departure; }
    public String getDeparture() {return this.departure; }
}
