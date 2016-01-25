package MobileNet;


public abstract class Phone {
    String number;

    public Phone(String number) { this.number = number; }

    public String  getNumber() {return number;}

    protected abstract void call( String number );
    protected abstract void answer();
    protected abstract int sendSMS();
}


class IPhone extends Phone
{
    Akia operator;
    public static int num_calls;

    public IPhone(String number, Akia operator)
    {
        super(number);
        this.operator = operator;
    }

    @Override
    protected void call( String number )
    {
        num_calls++;

        if ( 1 == operator.connect(number))
            System.out.println("Call OK");
        else
            System.out.println("Wrong NUMBER");
    }

    @Override
    protected void answer() {
        System.out.println("IPhone: number=" + number);
    }

    @Override
    protected int sendSMS() {return 0;}
}

class Samsung extends Phone
{
    public static int num_calls;
    Akia operator;

    public Samsung(String number, Akia operator)
    {
        super(number);
        this.operator = operator;
    }

    @Override
    protected void call( String number )
    {
        num_calls++;

        if ( 1 == operator.connect(number))
            System.out.println("Call OK");
        else
            System.out.println("Wrong NUMBER");
    }

    @Override
    protected void answer() {
        System.out.println("Samsung: number=" + number);
    }

    @Override
    protected int sendSMS() {return 0;}
}