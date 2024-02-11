public class Tasks {

        public static String task1(int a) {
            if (a == 0) {
                return "Вірно";
            } else {
                return "Невірно";
            }


        }

        public static String task2(int a) {
            if (a > 0) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }

        public static String task3(int a) {
            if (a < 0) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }

        public static String task4(int a) {
            if (a >= 0) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }

        public static String task5(int a) {
            if (a <= 0) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }

        public static String task6(int a) {
            if (a != 0) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }

        public static String task7(Object a) {
           return a == "test" ? "Вірно" : "Невірно";
        }

        public static String task8(Object a) {
            return a == "1" ? "Вірно" : "Невірно";
        }
        public static String task9_1(boolean test) {
            if (test) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }
        public static String task9_2(boolean test) {
            return test ? "Вірно" : "Невірно";
        }
        public static String task10_1(boolean test) {
            if (!test) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }
        public static String task10_2(boolean test) {
            return !test ? "Вірно" : "Невірно";
        }
        public static String task11(int a) {
            if (a > 0 && a < 5) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }
        public static float task12(float a) {
            if (a == 0 || a == 2) {
                return a+7;
            } else {
                return a/10;
            }
        }
        public static int task13(int a, int b) {
            if (a <= 1 && b >= 3) {
                return a+b;
            } else {
                return a-b;
            }
        }
        public static String task14(int a, int b) {
            if (a > 2 && a < 11 || b >= 6 && b < 14) {
                return "Вірно";
            } else {
                return "Невірно";
            }
        }
        public static String task15(int num){
            String result = "";
            switch (num){
                case (1):
                    result = "зима";
                    break;
                case (2):
                    result = "весна";
                    break;
                case (3):
                    result = "літо";
                    break;
                case (4):
                    result = "осінь";
                    break;
            }
            return result;
        }
}