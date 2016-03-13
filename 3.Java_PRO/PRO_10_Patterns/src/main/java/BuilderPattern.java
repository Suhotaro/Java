
public class BuilderPattern {
    public void run() {
        LaptopBuilder builder = Laptop.BUILDER;

        Laptop laptop = builder.create()
                .setProcessor(Processor.AMD)
                .setHdd(12345)
                .setRam(4 * 1024)
                .setTouchDisplay(false)
                .build();

        System.out.println("Build Laptop: \n" +
                "  processor: " + laptop.getProcessor()  + "\n" +
                "  hdd: " + laptop.getHhd()  + "\n" +
                "  ram: " + laptop.getRam()  + "\n" +
                "  OS: " + laptop.getOs()  + "\n" );
    }
}

enum Processor {Intel, AMD};
enum OS {Windows8, Windows7, Linux};

class Laptop {
    public static final LaptopBuilder BUILDER = new LaptopBuilder();

    Processor processor;
    OS os;
    int ram;
    int hhd;
    boolean touchDisplay;

    public Processor getProcessor() {
        return processor;
    }

    public OS getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public int getHhd() {
        return hhd;
    }

    public boolean isTouchDisplay() {
        return touchDisplay;
    }
}

class LaptopBuilder {
    private Laptop laptop;

    public LaptopBuilder create() {
        laptop = new Laptop();
        return this;
    }

    public Laptop build() {
        return laptop;
    }

    public LaptopBuilder setProcessor(Processor processor) {
        laptop.processor = processor;
        return this;
    }

    public LaptopBuilder setRam(int ram) {
        laptop.ram = ram;
        return this;
    }

    public LaptopBuilder setHdd(int hdd) {
        laptop.hhd = hdd;
        return this;
    }

    public LaptopBuilder setTouchDisplay(boolean touchDisplay) {
        laptop.touchDisplay = touchDisplay;
        laptop.os = OS.Windows8; /* It supports such dispalys*/
        return this;
    }
}