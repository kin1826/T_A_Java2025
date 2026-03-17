package SWING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login {
    private JFrame frame = new JFrame();

    private JLabel username = new JLabel("Username:");
    private JLabel password = new JLabel("Password:");
    private JTextField usernameField = new JTextField(15);
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton login = new JButton("Login");

    public Login() {
        frame.setTitle("Login Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10)); // khoảng cách giữa các vùng

        // ----- Tiêu đề -----
        JLabel title = new JLabel("Welcome - Please Login", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(title, BorderLayout.NORTH);

        // ----- Form chính (ở giữa) -----
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); // lề trong

        formPanel.add(username);
        formPanel.add(usernameField);
        formPanel.add(password);
        formPanel.add(passwordField);

        frame.add(formPanel, BorderLayout.CENTER);

        // ----- Nút Login -----
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(login);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // ----- Hoàn tất -----
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check(usernameField.getText(), passwordField.getText())) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                } else {
                    JOptionPane.showMessageDialog(frame, "Login Failed");
                }
            }
        });
    }

    public boolean check(String username, String password) {
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new Login();
    }
}