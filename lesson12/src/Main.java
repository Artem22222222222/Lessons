import task2.GraphicEditor;

public class Main {
    public static void main(String[] args) {
//        Product a = new Electronic("phone",120,500,2,"ghp");
//        Product b = new Electronic("cdc",10,500,1,"ghp");
//        Product d = new Electronic("phone2",100,500,5,"ghp");
//        Order f = new Order("Artem", "tr 5", false);
//        f.add(a);
//        f.add(b);
//        f.add(d);
//        f.remove("phone");
//        f.myOrder();
        GraphicEditor a = new GraphicEditor();
        a.add(5, 12, "red", 52125, 180, 12);

        a.changeSizeLine(52125, new int[]{12});
        a.draw(52125);
    }
}