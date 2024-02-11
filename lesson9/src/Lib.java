public class Lib {

    private int libSize = 10;
    Book[] books;
    int len;

    Lib(){
        books = new Book[libSize];
    }
    public void add(Book book){
        if (len < libSize) {
            books[len] = book;
            len++;
        }else {
            System.out.println("error, too many books");
        }
    }
    public void remove(String bookName){
        for (int i = 0; i < len; i++) {
            if (bookName==books[i].title){
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
        Book[] books2;
        books2 = new Book[libSize];
        int index = 0;
        for (int i = 0; i < books.length; i++){
            if (books[i] != null){
                books2[index] = books[i];
                index += 1;
            }
        }
        this.books = books2;
    }

}
