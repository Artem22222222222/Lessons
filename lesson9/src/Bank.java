public class Bank {
    private int Password = 255196;
    private int bankSize = 10;
    private BankAccounts[] bankAccounts;
    private static int len;
    Bank(){
        bankAccounts = new BankAccounts[bankSize];
    }
    public void add(BankAccounts BankAccount){
        if (len < bankSize) {
            bankAccounts[len] = BankAccount;
            len++;
        }else {
            System.out.println("error, too many bank accounts");
        }
    }
    public void block(BankAccounts name, boolean block, int password){
        if (password == Password){
            name.setIsnotBlock(block);
        }else {
            System.out.println("wrong password");
        }
    }
}