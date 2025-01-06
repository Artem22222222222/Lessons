public class Bank {
    Object syncObject = new Object();
    double balance;

    public Bank(double balance) {
        this.balance = balance;
    }

    public void deposit(double sum){
        Transaction transaction = new Transaction(this, Actions.deposit, sum);
        transaction.start();
    }

    public void withdraw(double sum){
        Transaction transaction = new Transaction(this, Actions.withdraw, sum);
        transaction.start();
    }
}
