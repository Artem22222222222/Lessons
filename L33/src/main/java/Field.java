import java.util.ArrayList;

public class Field {
    public static String draw(ArrayList<String> field){
        String s = "";
        for (int i = 0; i < field.size(); i++) {
            if (i%3==0 && i != 0) {
                s += "\n"+field.get(i);
            }else {
                s += field.get(i);
            }
        }
        return s;
    }
}
