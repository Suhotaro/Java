package ATM;

public class ATM {
    public void run()
    {
        Account acc = new Account(1000);
        Transaction[] transactions = {
                new Transaction(acc, 100),
                new Transaction(acc, 500),
                new Transaction(acc, 200),
                new Transaction(acc, 50),
                new Transaction(acc, 150)
        };

        for (Transaction t : transactions)
            t.start();

        for (Transaction t : transactions) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Total: " + acc.get());
    }
}

class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int get() {
        return money;
    }

    public void set(int money) {
        this.money = money;
    }
}

class Transaction extends Thread {
    private Account account;
    private int withdraw;

    public Transaction(Account account, int withdraw) {
        this.account = account;
        this.withdraw = withdraw;
    }

//    public void run() {
//        try { // ���� ��� �������� ��������� �������������� ������� � �������
//            Thread.sleep(System.currentTimeMillis() % 50);
//        } catch (InterruptedException e) {}
//
//        synchronized (account) { // ������� ������ �� �����
//            int total = account.get();
//            if (total >= withdraw)
//                account.set(total - withdraw);
//        }
//    }

    public synchronized void run() {
        try { // ���� ��� �������� ��������� �������������� ������� � �������
            Thread.sleep(System.currentTimeMillis() % 50);
        } catch (InterruptedException e) {}

        int total = account.get();
        if (total >= withdraw)
            account.set(total - withdraw);
    }
}
