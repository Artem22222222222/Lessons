public class Main {
    public static void main(String[] args) {
//        System.out.println(fact(5));
        print(5);
    }

    public static void print(int num){
        int sum = 1;
        if (num==0)
            return;


        print(sum*num-1);

    }
}