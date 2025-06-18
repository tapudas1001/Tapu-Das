public class Book {
    private String name;
    private String author;
    private String isbn;

    public Book(String name, String author, String isbn) {
        this.name = name;
        this.author = author;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String toFileString() {
        return name + "," + author + "," + isbn;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",", 3);
        if (parts.length == 3) {
            return new Book(parts[0], parts[1], parts[2]);
        }
        return null;
    }
}
