import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookPage extends JFrame implements ActionListener {
    JTextField bookField, authorField, isbnField;
    JButton addButton, backButton;

    public AddBookPage() {
        setTitle("Add Book");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("background1.jpg"));
        backgroundLabel.setLayout(null);

        JLabel label = new JLabel("Book Name:");
        label.setBounds(80, 60, 120, 30);
        label.setForeground(Color.WHITE);

        bookField = new JTextField();
        bookField.setBounds(210, 60, 280, 30);

        JLabel authorLabel = new JLabel("Author Name:");
        authorLabel.setBounds(80, 110, 120, 30);
        authorLabel.setForeground(Color.WHITE);

        authorField = new JTextField();
        authorField.setBounds(210, 110, 280, 30);

        JLabel isbnLabel = new JLabel("ISBN:");
        isbnLabel.setBounds(80, 160, 120, 30);
        isbnLabel.setForeground(Color.WHITE);

        isbnField = new JTextField();
        isbnField.setBounds(210, 160, 280, 30);

        addButton = new JButton("Add Book");
        addButton.setBounds(160, 230, 130, 40);
        addButton.addActionListener(this);

        backButton = new JButton("Back");
        backButton.setBounds(320, 230, 130, 40);
        backButton.addActionListener(this);

        backgroundLabel.add(label);
        backgroundLabel.add(bookField);
        backgroundLabel.add(authorLabel);
        backgroundLabel.add(authorField);
        backgroundLabel.add(isbnLabel);
        backgroundLabel.add(isbnField);
        backgroundLabel.add(addButton);
        backgroundLabel.add(backButton);

        setContentPane(backgroundLabel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = bookField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();

            if (name.isEmpty() || author.isEmpty() || isbn.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            LibrarySystem.books.add(new Book(name, author, isbn));
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            bookField.setText("");
            authorField.setText("");
            isbnField.setText("");
        } else if (e.getSource() == backButton) {
            new WelcomePage();
            dispose();
        }
    }
}
