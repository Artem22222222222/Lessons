public class Main {
    public static void main(String[] args) {
        Bank user = new Bank(10);

        user.deposit(1);
        user.deposit(10);
        user.withdraw(100);
        user.withdraw(1000);

        Bank user2 = new Bank(0);

        user2.deposit(50);
        user2.deposit(100);
        user2.withdraw(10);
        user2.withdraw(100);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(user.balance);
        System.out.println(user2.balance);
    }
}



class Transaction extends Thread{
    private Actions a;
    private double sum;
    private Bank bank;
    public Transaction(Bank bank, Actions a, double sum) {
        this.a = a;
        this.sum = sum;
        this.bank = bank;
    }

    @Override
    public void run() {
        if (a == Actions.deposit){
            d();
        }else if (a == Actions.withdraw){
            w();
        }
    }
    public void d(){
        synchronized (bank.syncObject){
            bank.balance += sum;
        }
    }

    public void w(){
        synchronized (bank.syncObject){
            bank.balance -= sum;
        }
    }
}