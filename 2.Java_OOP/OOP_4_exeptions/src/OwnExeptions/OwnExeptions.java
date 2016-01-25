package OwnExeptions;


class WidthException extends Exception {
    public WidthException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "WidthException: " + super.getMessage();
    }
}

class HeightException extends Exception {
    public HeightException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "HeightException: " + super.getMessage();
    }
}

class Rectangle {
    private int height, width;

    public void setHeight(int h) throws HeightException {
        if (h < 0)
            throw new HeightException("wrong height");
        height = h;
    }

    public void setWidth(int w) throws WidthException {
        if (w < 0)
            throw new WidthException("wrong width");
        width = w;
    }
}


public class OwnExeptions {

    public void run() {
        Rectangle r = new Rectangle();

        try {
            r.setHeight(10);
            r.setWidth(-5);
        } catch (HeightException e) {
            System.out.println(e.getMessage());
        } catch (WidthException e) {
            System.out.println(e.getMessage());
        }

        try {
            r.setHeight(-9);
            r.setWidth(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
