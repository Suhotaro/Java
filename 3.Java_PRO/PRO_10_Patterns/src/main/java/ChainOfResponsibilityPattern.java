

public class ChainOfResponsibilityPattern {

    public SupportEngineer createChain()
    {
        SupportEngineer se = new BasicSupportEngineer();

        SupportEngineer fe = new FinancialSupportEngineer();
        se.setNext(fe);

        SupportEngineer ae = new ApplicationSupportEngineer();
        fe.setNext(ae);

        return se;
    }

    public void run ()
    {
        SupportEngineer chain = createChain();

        chain.message("AAA", SupportEngineer.TYPE_BASIC);
        chain.message("BBB", SupportEngineer.TYPE_APPLICATION);
    }
}

abstract class SupportEngineer
{
    public static final int TYPE_BASIC = 1;
    public static final int TYPE_FINANCIAL = 2;
    public static final int TYPE_APPLICATION = 3;

    protected int type;
    protected SupportEngineer next;

    public void setNext(SupportEngineer next) {
        this.next = next;
    }

    public void message(String msg, int type)
    {
        if (type == this.type)
            process(msg);
        else if (next != null)
            next.message(msg, type);
    }

    protected abstract void process(String msg);
}

class FinancialSupportEngineer extends SupportEngineer {

    public  FinancialSupportEngineer() {
        type = TYPE_FINANCIAL;
    }

    @Override
    protected void process(String msg){
        System.out.println("TYPE_FINANCIAL: " + msg);
    }
}

class ApplicationSupportEngineer extends SupportEngineer {

    public  ApplicationSupportEngineer() {
        type = TYPE_APPLICATION;
    }

    @Override
    protected void process(String msg){
        System.out.println("TYPE_APPLICATION: " + msg);
    }
}

class BasicSupportEngineer extends SupportEngineer {

    public  BasicSupportEngineer () {
        type = TYPE_BASIC;
    }

    @Override
    protected void process(String msg){
        System.out.println("TYPE_BASIC: " + msg);
    }
}