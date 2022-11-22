package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton view, add, update, remove;

    Home() {
        setLayout(null);

        ImageIcon i1 = new ImageIcon("Project/icons/home.png"); // get image
        Image i2 = i1.getImage().getScaledInstance(450, 270, Image.SCALE_DEFAULT); // returns Image class obj
        ImageIcon i3 = new ImageIcon(i2); // image to ImageIcon
        JLabel image = new JLabel(i3);
        image.setBounds(140, 120, 1050, 350); // left,top,len,width
        add(image);

        JLabel heading = new JLabel("Client Management System");
        heading.setBounds(210, 30, 600, 50);
        heading.setFont(new Font("Raleway", Font.BOLD, 35));
        add(heading);

        add = new JButton("Add Client");
        add.setBounds(40, 60, 180, 50);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        image.add(add);

        view = new JButton("View Clients");
        view.setBounds(40, 120, 180, 50);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        image.add(view);

        update = new JButton("Update Client");
        update.setBounds(40, 180, 180, 50);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        image.add(update);

        remove = new JButton("Remove Client");
        remove.setBounds(40, 240, 180, 50);
        remove.addActionListener(this);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        image.add(remove);

        setSize(950, 600);
        setLocation(200, 70);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddClient();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewClient();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewClient();
        } else {
            setVisible(false);
            new RemoveClient();
        }
    }

    public static void main(String args[]) {
        new Home();
    }
}
