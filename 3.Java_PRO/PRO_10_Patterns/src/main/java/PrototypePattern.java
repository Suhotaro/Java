import java.util.HashMap;
import java.util.Map;

public class PrototypePattern {
    public void run() {

        Product product = ProductShelf.getProduct("Queen - Who wants to live forever");
        System.out.println("Get Prototype: \n" +
            product.toString());

    }
}

class Product implements Cloneable {
    private String name;
    private double price;

    public Product (String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Object clone() {
        Object res = null;
        try
        {
            res = super.clone();
        }catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }
        return res;
    }

    @Override
    public String toString() {
        return " " + name + " " + price;
    }

}

class DigitalBook extends Product {
    private String author;

    public DigitalBook (String name, double price) {
        super(name, price);
    }

    @Override
    public Object clone() {
        Object res = null;
        res = super.clone();
        return res;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class MP3Track extends Product {
    private String author;
    private double duration;
    private double bitrate;

    public MP3Track (String name, double price) {
        super(name, price);
    }

    @Override
    public Object clone() {
        Object res = null;
        res = super.clone();
        return res;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setBitrate(double bitrate) {
        this.bitrate = bitrate;
    }

    @Override
    public String toString() {
        return author + super.toString();
    }

}

class ProductShelf {
    private static Map<String, Product> shelf = new HashMap<String, Product>();

    static {
        DigitalBook book = new DigitalBook("Java Apllication on Linux", 100);
        book.setAuthor("Carl Ablbing and Michael Schwarz");
        shelf.put("Java Apllication on Linux", book);

        book = new DigitalBook("Core servlets and Java Serve Pages", 150);
        book.setAuthor("Marty Hall");
        shelf.put("Core servlets and Java Serve Pages", book);

        MP3Track track = new MP3Track("Queen - Who wants to live forever", 2);
        track.setAuthor("Queen");
        track.setDuration(5.15);
        track.setBitrate(192);

        shelf.put("Queen - Who wants to live forever", track);
    }

    public static Product getProduct(String name) {
        return (Product) shelf.get(name).clone();
    }
}