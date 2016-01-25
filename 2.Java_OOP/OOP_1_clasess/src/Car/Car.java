package Car;

public class Car {
    private String name;
    private Engine engine; // мотор
    private Climate climate = new Climate(); // климат-контроль

    public Car(String name) {
        this.name = name;
        engine = new Engine(0, 10);
    }

    public Car(String name, double mileage, double fuel_consuption) {
        this.name = name;
        engine = new Engine(mileage, fuel_consuption);
    }

    public String getName() {
        return name;
    }
    public double getMileage() {
        return engine.getMileage();
    }
    public double getFuelAte() {
        return engine.getFuelAte();
    }

    // завести мотор
    public void turnOn() {
        engine.turnOn();
        climate.turnOn();
        climate.setTemperature(21);
    }

    // заглушить мотор
    public void turnOff() {
        climate.turnOff();
        engine.turnOff();
    }

    // установить скорость
    public void start(int speed, double hours) {
        if (engine.isStarted()) { // еще не заведен мотор
            // пройденная дистанция
            double distance = hours * speed;
            double fuel_ate = (engine.getFuelConsuption() * distance) / 100;

            engine.setFuelAte(fuel_ate);
            engine.addMileage(distance);
        }
    }
}