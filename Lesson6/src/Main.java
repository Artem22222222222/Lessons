public class Main {
    public static void main(String[] args) {
        int[][] arr = {{-100, 157, -57}, {2000, 1000, 1}, {-1, 10, -10}};
//        Task1(arr);
//        Task2(arr);
//        Task3(arr);
//        Task4_1(arr);
//        Task5(arr);
//        Task6(arr);
//        Task8(arr);
//        Task9(arr);
//        Task10(arr);
//        Task11(arr);
//        Task12(arr);
//        Task13(arr);
//        Task14(arr, 1000);
//        Task15(arr);

    }

    public static void Task1(int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                sum += ar[i][j];
            }

        }
        System.out.println(sum);
    }

    public static void Task2(int[][] ar) {
        int sum = 0;
        int length = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                sum += ar[i][j];
                length += 1;
            }

        }
        System.out.println(sum / length);
    }

    public static void Task3(int[][] ar) {
        int max = ar[0][0];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                for (int k = 0; k < ar[i].length - 1; k++) {
                    if (max < ar[i][k + 1]) {
                        max = ar[i][k + 1];
                    }
                }
            }
            System.out.println(max);
        }
    }

    public static void Task4(int[][] ar) {
        int min = ar[0][0];
        int max2 = ar[0].length;
        int index = 0;
        int index2 = 0;
        int max_index = 0;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].length > max2) {
                max2 = ar[i].length;
                index = i;
                max_index += 1;
            }
        }
        if (index == 0) {
            max_index += 1;
        }

        for (int i = 0; i < ar[index].length; i++) {
            min = ar[index2][i];
            for (int j = 0; j < ar.length; j++) {
                for (int k = 0; k < ar.length - 1; k++) {
                    if (ar[k].length > ar[index2].length && i == ar[index2].length - 1) {
                        index2 = i;
                    }
                    if (max_index == 1 && i == ar[index].length - 1) {
                        System.out.println(min);
                        break;
                    } else if (min > ar[k + 1][i]) {
                        min = ar[k + 1][i];
                    }

                }
            }
            System.out.println(min);
        }
    }//я намагався зробити універсальну функцію, але не зміг доробити її

    public static void Task4_1(int[][] ar) {
        int min = ar[0][0];
        for (int i = 0; i < ar[1].length; i++) {
            min = ar[0][i];
            for (int j = 0; j < ar.length; j++) {
                if (min > ar[j][i]) {
                    min = ar[j][i];
                }
            }
            System.out.println(min);
        }
    }

    public static void Task5(int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                sum += ar[i][j];
            }
            System.out.println(sum);
            sum = 0;
        }
    }

    public static void Task6(int[][] ar) {
        int YesNo = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (j == i && ar[i][j] < 1) {
                    YesNo = 1;
                }
                if (YesNo == 1) {
                    break;
                }
            }

        }
        if (YesNo == 1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

    }

    public static void Task7(int[][] ar, int num, int num2) {
        int[] ar1 = {};
        int[] ar2 = {};
        ar1 = ar[num];
        ar2 = ar[num2];
        ar[num] = ar2;
        ar[num2] = ar1;


    }

    public static void Task8(int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] < 1) {
                    for (int s = 0; s < ar[i].length; s++) {
                        sum += ar[i][s];
                    }
                    System.out.println(sum);
                    sum = 0;
                }
            }
        }
    }

    public static void Task9(int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] % 2 == 0) {
                    sum += 1;
                }

            }
        }
        System.out.println(sum);
    }

    public static void Task10(int[][] ar) {
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] < 1) {
                    sum += 1;
                }


            }
        }
        System.out.println(sum);
    }
    public static void Task11(int[][] ar) {
        int number = 1;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (ar[i][j] == 0) {
                    ar[i][j] = number;
                    number += 1;
                }

            }
        }
    }
    public static void Task12(int[][] ar) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (j == i) {
                    sum1 += ar[i][j];
                }
                if (i == 2-j){
                    sum2 += ar[i][j];
                }
            }

        }
        if (sum1 == sum2) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    public static void Task13(int[][] ar) {
        int sum1 = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[i].length; j++) {
                if (i == 2-j){
                    sum1 += ar[i][j];
                }
            }

        }
        System.out.println(sum1);
    }
    public static void Task14(int[][] ar, int num){
        int sum = 0;
        for (int i = 0; i < ar.length; i++){
            for (int j = 0; j < ar[j].length - 1; j++){
                if (ar[i][j] < num){
                    sum += 1;
                }
                if (ar[i][j+1] < num && j == ar[j].length - 2){
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
    public static void Task15(int[][] ar){
        int YesNo = 0;
        for (int i = 0; i < ar.length; i++){
            for (int j = 0; j < ar[j].length - 1; j++){
                for (int a = 0; a < ar.length; a++){
                    for (int s = j + 1; s < ar[i].length; s++) {
                       if (ar[i][j] == ar[a][s]) {
                          YesNo = 1;
                          break;
                       }
                    }
                }

            }
        }
        if (YesNo == 1){
            System.out.println("No");
        }else {
            System.out.println("Yes");
        }

    }

}