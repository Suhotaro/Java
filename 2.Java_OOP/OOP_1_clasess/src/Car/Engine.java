package Car;


public class Engine {
    private double mileage;
    private boolean started;
    private  double fuel_consuption;
    private  double fuel_ate;

    public Engine(double mileage, double fuel_consuption)
    {
        this.mileage = mileage;
        this.fuel_consuption = fuel_consuption;
    }

    public double getMileage() {
        return mileage;
    }

    public double getFuelConsuption() {
        return fuel_consuption;
    }

    public double getFuelAte() {
        return fuel_ate;
    }

    public void setFuelAte(double fuel_ate) {
        this.fuel_ate += fuel_ate;
    }

    public void addMileage(double mileage) {
        if (started)
            this.mileage += mileage;
    }

    public boolean isStarted() {
        return started;
    }

    public void turnOn() {
        started = true;
    }

    public void turnOff() {
        started = false;
    }
}
