package Doc;

public class Doc {
    public void run() {
        Document doc = new Document();

        Sender[] senders = {
                new Sender(doc, "one@mail.com"),
                new Sender(doc, "two@mail.com"),
                new Sender(doc, "three@mail.com"),
                new Sender(doc, "four@mail.com")
        };

        // отправл€ют сканированный документ разным адресатам
        for (Sender sender : senders)
            sender.start();

        DigitalScanner pr = new DigitalScanner(doc);
        pr.start();
    }
}

