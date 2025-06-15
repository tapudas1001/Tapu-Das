import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ViewBooksPage extends JFrame implements ActionListener {
    JButton backButton;
    JTextArea textArea;

    public ViewBooksPage() {
        setTitle("View Books");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        backButton = new JButton("Back");
        backButton.addActionListener(this);

        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);

        displayBooks();

        setVisible(true);
    }

    private void displayBooks() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Book> books = LibrarySystem.books;
        if (books.isEmpty()) {
            sb.append("No books available.");
        } else {
            for (Book b : books) {
                sb.append("Name: ").append(b.name).append("\n");
                sb.append("Author: ").append(b.author).append("\n");
                sb.append("ISBN: ").append(b.isbn).append("\n\n");
            }
        }
        textArea.setText(sb.toString());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new WelcomePage();
            dispose();
        }
    }
}
