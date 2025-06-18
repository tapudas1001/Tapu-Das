import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePage extends JFrame implements ActionListener {
    JButton btnLogin, btnNext, btnSignup, btnViewBooks;
    JTextField userField;
    JPasswordField passField;

    public WelcomePage() {
        setTitle("AIUB Library");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel backgroundLabel = new JLabel(new ImageIcon("background1.jpg"));
        backgroundLabel.setLayout(null);

        btnSignup = new JButton("Signup");
        btnSignup.setBounds(470, 20, 100, 30);
        btnSignup.addActionListener(this);

        JLabel label = new JLabel("Welcome to AIUB Library");
        label.setBounds(120, 80, 400, 50);
        label.setFont(new Font("Arial", Font.BOLD, 32));
        label.setForeground(Color.WHITE);

        JLabel userLabel = new JLabel("Student ID:");
        userLabel.setBounds(150, 160, 100, 30);
        userLabel.setForeground(Color.WHITE);

        userField = new JTextField();
        userField.setBounds(270, 160, 180, 30);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(150, 200, 100, 30);
        passLabel.setForeground(Color.WHITE);

        passField = new JPasswordField();
        passField.setBounds(270, 200, 180, 30);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(170, 260, 100, 40);
        btnLogin.addActionListener(this);

        btnNext = new JButton("Next");
        btnNext.setBounds(310, 260, 100, 40);
        btnNext.addActionListener(this);

        btnViewBooks = new JButton("View Books");
        btnViewBooks.setBounds(230, 320, 140, 40);
        btnViewBooks.addActionListener(this);

        backgroundLabel.add(btnSignup);
        backgroundLabel.add(label);
        backgroundLabel.add(userLabel);
        backgroundLabel.add(userField);
        backgroundLabel.add(passLabel);
        backgroundLabel.add(passField);
        backgroundLabel.add(btnLogin);
        backgroundLabel.add(btnNext);
        backgroundLabel.add(btnViewBooks);

        setContentPane(backgroundLabel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = userField.getText();
        String pass = new String(passField.getPassword());

        if (e.getSource() == btnSignup) {
            new LoginPage();
            dispose();
        } else if (e.getSource() == btnLogin) {
            if (user.equals(LoginInfo.studentId) && pass.equals(LoginInfo.password)) {
                new AddBookPage();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials for Login");
            }
        } else if (e.getSource() == btnNext) {
            if (pass.equals(LoginInfo.password)) {
                new SearchIssuePage();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Password for Next");
            }
        } else if (e.getSource() == btnViewBooks) {
            new ViewBooksPage();
            dispose();
        }
    }
}
