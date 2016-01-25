package MobileNet;

public class RunMobileNet {

    public RunMobileNet() {;}

    public void run()
    {
        System.out.println(Akia.NAME);

        Akia akia = new Akia();

        Samsung samsung = new Samsung("111-22-33", akia);
        IPhone iphone = new IPhone("444-55-66", akia);

        akia.addIPhone(iphone);
        akia.addSamsung(samsung);

        samsung.call("444-55-66");
        samsung.call("444-44-22");
        samsung.call("444-55-11");

        iphone.call("111-22-77");

        System.out.println("Samsung number of calls: " + samsung.num_calls);
        System.out.println("IPhone number of calls: " + iphone.num_calls);

    }
}
