public class Main {
    public static void main(String[] args) {
        Controller c = new Controller();
        c.setModel(new Model(c));
         c.setUi(new UI(c));
    }
}