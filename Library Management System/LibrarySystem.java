import java.util.ArrayList;

public class LibrarySystem {
    public static ArrayList<Book> books;

    public static void main(String[] args) {
        books = BookFileManager.loadBooks();  // Load books from file at start
        new WelcomePage();
    }
}