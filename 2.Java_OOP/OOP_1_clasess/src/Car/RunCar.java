package Car;

public class RunCar {

    public RunCar()
    {

    }

    public void run()
    {
        Car bmw = new Car("BMW");
        Car ferrari = new Car("Ferrari", 20000, 15);

        bmw.turnOn();
        ferrari.turnOn();

        final int[] speeds = new int[] {20, 20};

        for (int s : speeds)
            bmw.start(s, 0.5);
        for (int s : speeds)
            ferrari.start(s, 200);

        bmw.turnOff();
        ferrari.turnOff();

        System.out.println(bmw.getName() + ": " + bmw.getMileage() + " " + bmw.getFuelAte());
        System.out.println(ferrari.getName() + ": " + ferrari.getMileage() + " " + ferrari.getFuelAte());
    }

}
