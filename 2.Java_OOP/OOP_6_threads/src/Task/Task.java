package Task;

import java.math.BigInteger;

interface IFinish {
    void done(BigInteger result);
}

 class Finish implements IFinish {
    @Override
    public void done(BigInteger result) {
        System.out.println(result);
    }
}

class RunTask extends Thread {
    IFinish finish;
    BigInteger n;

    public RunTask(BigInteger n, IFinish finish) {
        this.n = n;
        this.finish = finish;
    }

    private BigInteger fact(BigInteger x) {
        if (x.equals(BigInteger.ZERO))
            return BigInteger.ONE;
        else
            return x.multiply(fact(x.subtract(BigInteger.ONE)));
    }

    public void cut() {
        System.out.println("0: " + BigInteger.ZERO);
        System.out.println("1: " + BigInteger.ONE);
        System.out.println("10: " + BigInteger.TEN);
    }

    public void run() {
        BigInteger res = fact(n);
        if (finish != null)
            finish.done(res);
    }
}

public class Task {
    public void run ()
    {
        RunTask t = new RunTask(new BigInteger("100"), new Finish());
        t.start();
        System.out.println("Done!");

        t.cut();
    }
}
