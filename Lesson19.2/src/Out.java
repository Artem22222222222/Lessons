import java.util.ArrayList;

public class Out {
    private static ArrayList<Integer> numbers = new ArrayList<>();
    public static void print(){
        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size()-1){
                System.out.print(numbers.get(i));
            }else {
                System.out.print(numbers.get(i)+", ");
            }
        }
    }
    public static void add(int i){
        numbers.add(i);
    }

}
