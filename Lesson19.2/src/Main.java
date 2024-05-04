import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NotNumberException {
        ArrayList<Integer> a = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();



        String[] b;
        b = answer.split(" ");

        try {
            for (int i = 0; i < b.length; i++) {
                a.add(Integer.valueOf(b[i]));
            }
        }catch (Exception e){
            throw new NotNumberException();
        }


        IntStream intStream = a.stream().mapToInt(Integer::intValue);

        new Main().task5(intStream);


    }

    public void task1(IntStream intStream) {
        System.out.println(intStream.filter((x) -> x % 2 == 0).sum());
    }

    public void task2(IntStream intStream) {
        intStream.map((x) -> x * 2).forEach(System.out::println);
    }

    public void task3(IntStream intStream) {
        intStream.max().stream().forEach(System.out::println);
    }

    public void task4(IntStream intStream) {
        intStream
                .filter((x) -> x % 2 != 0)
                .forEach((Out::add));
        Out.print();
    }

    public void task5(IntStream intStream) {
        intStream.average().stream().forEach(System.out::println);
    }
}

