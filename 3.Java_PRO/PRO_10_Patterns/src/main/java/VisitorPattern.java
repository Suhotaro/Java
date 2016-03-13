
public class VisitorPattern {

    public void run() {
        Car car = new Car();
        car.accept(new RoutineCheckVisitor());
    }
}

interface CarPart {
    void accept(CarPartVisitor visitor);
}

class Engine implements CarPart {

    public void accept (CarPartVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "engine";
    }
}

class Wheel implements CarPart {
    private int num;

    public Wheel (int num) {this.num = num;}

    public void accept (CarPartVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "[wheel #" + num + "]";
    }
}

class Car implements CarPart {
    private CarPart []parts;

    public Car() {
        parts = new CarPart[] {new Engine(), new Wheel(1), new Wheel(2),
                new Wheel(3), new Wheel(4)};
    }

    public void accept (CarPartVisitor visitor) {
        visitor.visit(this);
        for (CarPart cp : parts)
            cp.accept(visitor);
    }

    @Override
    public String toString() {
        return "car";
    }
}

interface CarPartVisitor {
    void visit(Car car);
    void visit(Engine engine);
    void visit(Wheel wheel);
}

class RoutineCheckVisitor implements CarPartVisitor {
    public void visit (Car car) {
        System.out.println("Chekhing " + car);
    }

    public void visit (Engine engine) {
        System.out.println("Chekhing " + engine);
    }

    public void visit (Wheel wheel) {
        System.out.println("Chekhing " + wheel);
    }
}