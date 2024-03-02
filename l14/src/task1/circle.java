package task1;

public class circle implements figures {
   int r;

    public circle(int r) {
        this.r = r;
    }

    public void S (){
        double s = 3.14*r*r;
        System.out.println(s);
    }
}
