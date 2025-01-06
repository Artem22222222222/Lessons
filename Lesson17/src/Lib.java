import java.util.ArrayList;
import java.util.Objects;

public class Lib {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String autor, String title, int ISBN, int publicationyear) throws DuplicateBookException, InvalidYearException {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN() == ISBN){
                throw new DuplicateBookException();
            }
        }
        books.add(new Book(autor,title,ISBN,publicationyear));
    }

    public void remove(int ISBN) throws BookNotFoundException {
        books.remove(findBookByIsbn(ISBN));
    }

    public Book findBookByIsbn(int ISBN) throws BookNotFoundException{
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN() == ISBN){
                return books.get(i);
            }
        }
        throw new BookNotFoundException();
    }
    public ArrayList<Book> findBooksByAuthor(String author){
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (Objects.equals(books.get(i).getAutor(), author)){
                foundBooks.add(books.get(i));
            }
        }
        return foundBooks;
    }
    public ArrayList<Book> findBooksByYear(int year) throws InvalidYearException{
        if (year < 1){
            throw new InvalidYearException();
        }
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getPublicationYear() == year){
                foundBooks.add(books.get(i));
            }
        }
        return foundBooks;
    }
}
