public class Main {
    public static void main(String[] args) {
        Lib lib = new Lib();
        Book book1 = new Book("hjjkf","rvhk",12);
        lib.add(book1);
        Book book2 = new Book("aaaaa","bbbb",14);
        lib.add(book2);
        lib.print();
        lib.remove("hjjkf");
        lib.print();
    }
}