import java.util.ArrayList;

public class Field {
    public static String draw(ArrayList<String> field){
        String s = "";
        for (int i = 0; i < field.size(); i++) {
            if (i%3==0) {
                s += field.get(i)+"\n";
            }else {
                s += field.get(i);
            }
        }
        return s;
    }
}
