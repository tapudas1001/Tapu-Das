import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    JTextField txtUser;
    JPasswordField txtPass, txtConfirm;
    JButton btnSubmit;

    public LoginPage() {
        setTitle("Signup");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel userLabel = new JLabel("New Student ID:");
        userLabel.setBounds(50, 40, 120, 30);
        add(userLabel);

        txtUser = new JTextField();
        txtUser.setBounds(170, 40, 150, 30);
        add(txtUser);

        JLabel passLabel = new JLabel("New Password:");
        passLabel.setBounds(50, 80, 120, 30);
        add(passLabel);

        txtPass = new JPasswordField();
        txtPass.setBounds(170, 80, 150, 30);
        add(txtPass);

        JLabel confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setBounds(50, 120, 120, 30);
        add(confirmLabel);

        txtConfirm = new JPasswordField();
        txtConfirm.setBounds(170, 120, 150, 30);
        add(txtConfirm);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(130, 180, 120, 40);
        btnSubmit.addActionListener(this);
        add(btnSubmit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String user = txtUser.getText();
        String pass = new String(txtPass.getPassword());
        String confirm = new String(txtConfirm.getPassword());

        if (user.isEmpty() || pass.isEmpty() || confirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        if (!pass.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }

        LoginInfo.studentId = user;
        LoginInfo.password = pass;
        JOptionPane.showMessageDialog(this, "Signup successful!");
        new WelcomePage();
        dispose();
    }
}
