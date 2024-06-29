public class Main {
    public static void main(String[] args) {
        System.out.println(fact(5));
    }
//    void - нічого не повертае

    public static int fact(int num){//5  = 1*2*3*4*5 = 120
        int sum = 1;
        for (int i = 1; i < num; i++)
            sum = i*sum;
        return sum;
    }
}