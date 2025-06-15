import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class SearchIssuePage extends JFrame implements ActionListener {
    JTextField bookField;
    JButton btnSearch, btnIssue, backButton;
    Book currentBook = null;

    public SearchIssuePage() {
        setTitle("Search & Issue Book");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("background2.jpg"));
        backgroundLabel.setLayout(null);

        JLabel label = new JLabel("Enter Book Name to Search:");
        label.setBounds(140, 60, 300, 30);
        label.setForeground(Color.WHITE);

        bookField = new JTextField();
        bookField.setBounds(140, 100, 280, 30);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(180, 150, 100, 40);
        btnSearch.addActionListener(this);

        btnIssue = new JButton("Issue");
        btnIssue.setBounds(320, 150, 100, 40);
        btnIssue.addActionListener(this);
        btnIssue.setEnabled(false);

        backButton = new JButton("Back");
        backButton.setBounds(230, 210, 140, 40);
        backButton.addActionListener(this);

        backgroundLabel.add(label);
        backgroundLabel.add(bookField);
        backgroundLabel.add(btnSearch);
        backgroundLabel.add(btnIssue);
        backgroundLabel.add(backButton);

        setContentPane(backgroundLabel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String searchName = bookField.getText().trim();
            if (searchName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a book name.");
                return;
            }

            currentBook = null;
            for (Book b : LibrarySystem.books) {
                if (b.name.equalsIgnoreCase(searchName)) {
                    currentBook = b;
                    break;
                }
            }

            if (currentBook != null) {
                JOptionPane.showMessageDialog(this, "Book Found:\nName: " + currentBook.name +
                        "\nAuthor: " + currentBook.author + "\nISBN: " + currentBook.isbn);
                btnIssue.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Book not found.");
                btnIssue.setEnabled(false);
            }
        } else if (e.getSource() == btnIssue) {
            if (currentBook != null) {
                JOptionPane.showMessageDialog(this, "Book '" + currentBook.name + "' issued on " + LocalDate.now());
                btnIssue.setEnabled(false);
            }
        } else if (e.getSource() == backButton) {
            new WelcomePage();
            dispose();
        }
    }
}
