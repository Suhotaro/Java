package Phones;

public class SamsungS4 extends Phone {
    public SamsungS4() {
        System.out.println("Samsung constructor");

        touch = true;
        hasWifi = true;
        screenSize = 5;
    }

    final public void call(String number) {
        System.out.println("IPhone class is calling " + number);
    }

    @Override
    public void sendSMS(String number, String message) {
        System.out.println("Samsung class is sending sms " + message + " to " + number);

    }
}
