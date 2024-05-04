public class Book {
    private String autor;
    private String title;
    private int  ISBN;
    private int publicationYear;

    public Book(String autor, String title, int ISBN, int publicationYear) throws InvalidYearException{
        this.autor = autor;
        this.title = title;
        this.ISBN = ISBN;
        if (publicationYear < 1){
            throw new InvalidYearException();
        }else {
            this.publicationYear = publicationYear;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) throws InvalidYearException{
        if (publicationYear < 1){
            throw new InvalidYearException();
        }else {
            this.publicationYear = publicationYear;
        }
    }
}
