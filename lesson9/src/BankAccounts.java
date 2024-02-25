public class BankAccounts {
    private String name;
    private int money;
    private boolean isnotBlock = true;
    public BankAccounts(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public boolean isIsnotBlock() {
        return isnotBlock;
    }

    public void setIsnotBlock(boolean isnotBlock) {
        this.isnotBlock = isnotBlock;
    }

    public void addMoney(int number){
        if (isnotBlock) {
            money += number;
        }
    }
    public void removeMoney(int number){
        if (isnotBlock){
            money -= number;
        }
    }
    public static void exchange(BankAccounts who, BankAccounts toWhom, int number){
        if (who.isnotBlock || toWhom.isnotBlock){
            who.removeMoney(number);
            toWhom.addMoney(number);
        }

    }
    public void score(){
        System.out.println(money);
    }
}
