import java.util.ArrayList;
import java.util.List;

public class MementoPattern {

    public void run() {
        List<Memento> states = new ArrayList<Memento>();

        Editor editor = new Editor("AAA AAA AAA", BackgroundColor.WHITE);

        editor.setText("BBB BBB BBB");
        editor.setBackgroundColor(BackgroundColor.BLACK);
        states.add(editor.saveToMemento());

        editor.setText("CCC CCC CCC");
        states.add(editor.saveToMemento());

        editor.restoreFromMemento(states.get(0));

        System.out.println(editor.getText() + " " + editor.getBackgroundColor());
    }
}

enum BackgroundColor {WHITE, BLACK};

class Editor {
    private String text;
    private BackgroundColor backgroundColor;

    public Editor (String text, BackgroundColor backgroundColor) {
        this.text = text;
        this.backgroundColor = backgroundColor;
    }

    public String getText () {
        return text;
    }

    public void setText (String text) {
        this.text = text;
    }

    public BackgroundColor getBackgroundColor () {
        return backgroundColor;
    }

    public void setBackgroundColor (BackgroundColor backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Memento saveToMemento() {
        return  new Memento (text, backgroundColor);
    }

    public void restoreFromMemento (Memento memento) {
        this.text = memento.getText();
        this.backgroundColor = memento.getBackgroundColor();
    }
}

class Memento {

    private final String text;
    private final BackgroundColor backgroundColor;

    public Memento (String text, BackgroundColor backgroundColor) {
        this.text = text;
        this.backgroundColor = backgroundColor;
    }

    public String getText () {
        return text;
    }

    public BackgroundColor getBackgroundColor () {
        return backgroundColor;
    }
}
