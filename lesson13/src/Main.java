import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> task1 = new ArrayList<>();
        task1.add(2);
        task1.add(3);
        task1.add(3);
        ArrayList<Integer> task2 = new ArrayList<>();
        task1.add(2);
        task1.add(4);
        task1.add(4);
        Tasks.check(task1,5);
    }
}