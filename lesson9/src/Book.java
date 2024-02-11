public class Book {
    String title;
    String author;
    int publicationYear;
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    public void print(){
        System.out.println(title);
    }


}