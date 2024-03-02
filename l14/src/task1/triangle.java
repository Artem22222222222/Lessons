package task1;

import task1.figures;

public class triangle implements figures {
    int a;
    int h;
    public triangle(int a, int h) {
        this.a = a;
        this.h = h;

    }

    public void S (){
        double s = a*h;
        System.out.println(s);
    }
}

