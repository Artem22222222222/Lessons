public class Main {
    public static void main(String[] args) {
        Lib lib = new Lib();
        try {
            lib.addBook("fsvsd", "bdfscb", 1, 52);
            lib.addBook("fsvsd", "bdfscb", 2, 52);
            lib.findBookByIsbn(3);
        } catch (DuplicateBookException e) {
            throw new RuntimeException(e);
        } catch (InvalidYearException e) {
            throw new RuntimeException(e);
        } catch (BookNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}