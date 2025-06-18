import java.io.*;
import java.util.*;

public class BookFileManager {
    private static final String BOOKS_FILE = "books.txt";

    public static ArrayList<Book> loadBooks() {
        ArrayList<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(BOOKS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                Book b = Book.fromFileString(line);
                if (b != null) {
                    books.add(b);
                }
            }
        } catch (IOException e) {
            System.out.println("Books file not found or error reading it. Starting with empty list.");
        }
        return books;
    }

    public static void saveBook(Book book) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKS_FILE, true))) {
            bw.write(book.toFileString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving book: " + e.getMessage());
        }
    }
}
