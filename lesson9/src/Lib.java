public class Lib {

    private int libSize = 10;
    private Books[] books;
    private static int len;

    Lib(){
        books = new Books[libSize];
    }

    public int getLibSize() {
        return libSize;
    }

    public Books[] getBooks() {
        return books;
    }

    public int getLen() {
        return len;
    }


    public void setLibSize(int libSize) {
        this.libSize = libSize;
    }

    public void setBooks(Books[] books) {
        this.books = books;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public void add(Books book){
        if (len < libSize) {
            books[len] = book;
            len++;
        }else {
            System.out.println("error, too many books");
        }
    }
    public void remove(String bookName){
        for (int i = 0; i < len; i++) {
            if (bookName.equals(books[i].getTitle())){
                books[i] = null;
            }
        }
        clear();
        len--;
    }

    public void print() {
        for (int i = 0; i < len; i++) {
            System.out.print(i+1+" ");
            books[i].print();
        }

    }
    private void clear(){
        Books[] books2;
        books2 = new Books[libSize];
        int index = 0;
        for (int i = 0; i < books.length; i++){
            if (books[i] != null){
                books2[index] = books[i];
                index += 1;
            }
        }
        this.books = books2;
    }
    public void search(String bookName) {
        for (int i = 0; i < len; i++) {
            if (bookName.equals(books[i].getTitle())) {
                System.out.println(books[i].getAuthor());
            }
        }
    }
    public static void numberOfBooks(){
        System.out.println(len);
    }

}
