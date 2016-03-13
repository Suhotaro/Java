
public class TemplateMethodPattern {
    public void run ( ) {
        new OnlineTransaction().pay();
        new OflineTransaction().setViewBalance(true).pay();
    }
}

abstract class Transaction {
    private  boolean viewBalance;

    public abstract void enterPin();
    public abstract void withdrawMoney();
    public abstract void viewBalance();

    public Transaction setViewBalance(boolean value) {
        viewBalance = value;
        return this;
    }

    public void pay() {
        enterPin();
        withdrawMoney();
        if (viewBalance) viewBalance();
    }
}

class OnlineTransaction extends Transaction {
    @Override
    public void enterPin() {
        System.out.println("Performing 3D secure via your phone");
    }

    @Override
    public void withdrawMoney() {
        System.out.println("Withdraw money via online payment gateway");
    }

    @Override
    public void viewBalance() {
        System.out.println("View account balance via web interface");
    }
}

class OflineTransaction extends Transaction {
    @Override
    public void enterPin() {
        System.out.println("Entering PIN via terminal");
    }

    @Override
    public void withdrawMoney() {
        System.out.println("Withdraw money via internal bank payment gateway");
    }

    @Override
    public void viewBalance() {
        System.out.println("Print card balance in cheque");
    }
}