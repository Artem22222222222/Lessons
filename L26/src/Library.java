import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void add(Book book){
        books.add(book);
    }
    public void delete(int id){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id){
                books.remove(i);
            }
        }
    }
    public void see(){
        books.stream().forEach(x->System.out.println(x.getAutor()+" "+x.getId()+" "+x.getPublishYear()));
    }
}
