public class Main {
    public static void main(String[] args) {
        int[] ar = {15,8,1,7};
        int[] ar2 = {7,9,1,8};
        int[] ar3 = {1,1,5,2};
        insertSort(ar);
        Task2(ar2,ar3);
    }
    public static void insertSort(int[] ar){
        for (int i = 0; i < ar.length; i++) {
            for (int j = 1; j < ar.length; j++) {
                if (ar[ar.length - j - 1]>ar[ar.length - j]){
                    int tmp = ar[ar.length - j - 1];
                    ar[ar.length - j - 1] = ar[ar.length - j];
                    ar[ar.length - j] = tmp;
                }
            }
        }
        for (int i = 0; i < ar.length; i++){
            System.out.println(ar[i]);
        }
    }
//    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    public static void Task2 (int[] num1, int[] num2) {
        int[] sum = {0, 0, 0, 0};
        for (int i = 0; i < num1.length; i++) {
            sum[i] = num1[i] + num2[i];
        }
        for (int i = 1; i < sum.length; i++) {
            if (sum[i] > 9) {
                sum[i - 1] += sum[i] / 10;
                sum[i] = sum[i] % 10;
            }
        }
        for (int i = 0; i < sum.length; i++) {
            System.out.print(sum[i]);
        }
    }
}