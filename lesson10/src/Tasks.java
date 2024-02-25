import java.util.ArrayList;
import java.util.HashMap;

public class Tasks {
    public static String revers(String word){
        String word2 = "";
        for (int i = word.length() -1; i > -1; i--){
            word2 += word.charAt(i);
        }
        return word2;
    }
    public static int vowels(String word){
        int vowels = 0;
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' ||word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u'){
                vowels += 1;
            }
        }
        return vowels;
    }
    public static boolean palindrome(String word){
        word = word.toLowerCase();
        return word.equals(revers(word));
    }
    public static String removingDuplicates(String word){
        String Char = "";
        String word2 = word;
        for (int i = 0; i < word.length(); i++){
          for (int s = i+1; s < word.length(); s++){
              if (word.charAt(i) == word.charAt(s)){
                  Char += word.charAt(i);
                  word2 = word2.replaceFirst(Char,"");
                  Char = "";
                  break;
              }
          }
      }
        return word2;
    }
    public static String[] split(String word){
        String[] words = {};
        words = word.split(" ");
        return words;
    }
}
