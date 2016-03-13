import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandPattern {

    public void run() {
        TV tv = new TV();
        Lamp kitchenLamp = new Lamp("kitchen");
        Lamp bedroomLamp = new Lamp("bedroom");

        List<Device> lamps = Arrays.asList(new Device[] {kitchenLamp, bedroomLamp});

        Command comm1 = new TurnOnCommand(tv);
        Command comm2 = new TurnOffAllCommand(lamps);

        Switch sw = new Switch();
        sw.logAndExecute(comm1);
        sw.logAndExecute(comm2);
    }
}

interface Command {
    void execute();
}

class TurnOnCommand implements Command {
    private Device device;

    public  TurnOnCommand (Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOn();
    }
}

class TurnOffAllCommand implements Command {
    private List<Device> list;

    public  TurnOffAllCommand (List<Device> list) {
        this.list = list;
    }

    public void execute() {
        for (Device d : list)
            d.turnOff();
    }
}

interface Device {
    void turnOn();
    void turnOff();
}

class TV implements Device {

    public void turnOn() {
        System.out.println("TV turned on");
    }

    public void turnOff() {
        System.out.println("TV turned off");
    }
}

class Lamp implements Device {

    private String location;

    public Lamp(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println("Lamp in " + location + " turned on");
    }

    public void turnOff() {
        System.out.println("Lamp in " + location + " turned off");
    }
}

class Switch {
    List <String> log = new ArrayList<String>();

    public void logAndExecute (Command command) {
        log.add(command.getClass().getName() + " executed");
        command.execute();
    }
}