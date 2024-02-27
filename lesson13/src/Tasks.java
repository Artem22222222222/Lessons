import java.util.*;

import static java.util.Collections.sort;

public class Tasks {
    public static void sort1(ArrayList<Integer> list, boolean sort){
//        list.sort(list, sort);
        list.sort(
                (o1, o2) -> {
            int sortDirection = sort ? 1: -1;

            if (o1 > o2) return sortDirection * 1;
            if (o1 < o2) return sortDirection * -1;
            return 0;
        });

    }
    public static void removingDuplicates(ArrayList<String> list) {
        HashSet<String> list2 = new HashSet<>();
        list2.addAll(list);
        for (String i : list2) {
            System.out.println(i);
        }
    }
    public static int[] maxMin(ArrayList<Integer> list){
        sort1(list,true);
        int[] list2 = {list.getFirst(),list.getLast()};
        return list2;
    }
    public static void removingDuplicates2(ArrayList<Integer> list, ArrayList<Integer> list2) {
        HashSet<Integer> list3 = new HashSet<>();
        list3.addAll(list);
        list3.addAll(list2);
        for (int i : list3) {
            System.out.println(i);
        }
    }
    public static void check(ArrayList<Integer> list, int s){
        int a = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == s){
                System.out.println("Є");
                break;
            }else
                a++;
        }
        if (a == list.size()){
            System.out.println("Немає");
        }
    }
}
