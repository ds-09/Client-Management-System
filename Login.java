package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfUsername, tfPassword; // defined globally

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 20, 100, 30);
        add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 20, 150, 30);
        add(tfUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(40, 70, 100, 30);
        add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(150, 70, 150, 30);
        add(tfPassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(100, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this); // goes into actionPerfromed meth
        add(login);

        setSize(350, 250);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            // checking login credentials
            Conn c = new Conn();
            String query = "select * from login where username= '" + username + "' and password = '" + password + "'";

            ResultSet rs = c.s.executeQuery(query); // calls statement s through connectivity obj c, store in rs
            if (rs.next()) { // to check value in rs
                setVisible(false);
                new Splash();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
