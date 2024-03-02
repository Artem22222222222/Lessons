package task1;

import task1.figures;

public class rectangle implements figures {
    int a;
    int b;
    public rectangle(int a, int b) {
        this.a = a;
        this.b = b;

    }

    public void S (){
        double s = a*b;
        System.out.println(s);
    }
}
