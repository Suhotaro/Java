import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    static void run () {
        OfficeChat subject = new OfficeChat();
        Observer[] obs = {new Worker(), new Worker()};

        for (Observer o : obs) {
            subject.register(o);
            o.setSubject(subject);
        }

        subject.addMessage("new message");
        subject.notifyObservers();
    }
}

interface Observer {
    void update();
    void setSubject(Subject subject);
}

class Worker implements Observer {
    private Subject subject;

    public void update () {
        System.out.println("Update");
    }

    public void setSubject (Subject subject){
        this.subject = subject;
    }
}

interface Subject {
    public void register(Observer obs);
    public void unregister(Observer obs);
    public void notifyObservers();
}

class OfficeChat implements Subject {

    private List<Observer> list = new ArrayList<Observer>();
    private List<String> messages = new ArrayList<String>();
    private boolean changed;

    public void addMessage(String msg) {
        messages.add(msg);
        changed = true;
    }

    public void register (Observer obs) {
        list.add(obs);
    }

    public void unregister (Observer obs) {
        list.remove(obs);
    }

    public void notifyObservers() {
        if (changed) {
            for (Observer o: list)
                o.update();

            changed = false;
        }
    }
}