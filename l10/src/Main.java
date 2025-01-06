public class Main {
    public static void main(String[] args) {
        String a = "Hellojf worlds";
        System.out.println(theBigestWord(a));
    }

    public static String theBigestWord(String a) {
        String[] s = a.split(" ");
        int len = 0;
        String theBigest = "";
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() > len) {
                len = s[i].length();
                theBigest = s[i];
            }
        }
        return theBigest;
    }
}