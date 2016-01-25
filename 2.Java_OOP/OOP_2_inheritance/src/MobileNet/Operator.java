package MobileNet;

public abstract class Operator {

    protected abstract int find(String number);
    public abstract int connect(String number);
    protected abstract int connectSMS();
}

class Akia extends Operator
{
    public  static  final  String NAME = "Akia telecom";

    int i;
    int j;
    /* 1 - Samsung 2 - IPhone */
    int who;
    IPhone []listIPhone = new IPhone[5];
    Samsung []listSamsung = new Samsung[5];

    public Akia() {
        i = 0;
        j = 0;
        who = 0;
    }

    protected void addIPhone(IPhone phone) { listIPhone[i++] = phone; }
    protected void addSamsung(Samsung samsung) { listSamsung[j++] = samsung; }


    public int connect(String number) {

        int i = find(number);

        switch (who)
        {
            case 0:
                return 0;

            case 1:
                listSamsung[i].answer();
                return 1;

            case 2:
                listIPhone[i].answer();
                return 1;
        }

        return 0;
    }


    protected final int find(String number) {

        for (int i = 0; i < listSamsung.length; i++) {
            if (null == listIPhone[i]) {
                who = 0;
                return -1;
            }
            else if (number.equals(listSamsung[i].getNumber())) {
                who = 1;
                return i;

            } else if (number.equals(listIPhone[i].getNumber())) {
                who = 2;
                return i;
            }
        }

        who = 0;
        return -1;
    }

    protected int connectSMS() { return 0; }
}
