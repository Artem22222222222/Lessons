public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.add(new Book(52, "Artem", 2024));
        library.see();
        library.delete(52);
        library.see();
    }
}