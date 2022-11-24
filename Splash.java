package Project;

import javax.swing.*; //JFrame
import java.awt.*; //Color class
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame
        implements ActionListener {
    Splash() {
        getContentPane().setBackground(Color.BLACK); // layer to add obj
        setLayout(null); // layout of container- JFrame

        // heading
        JLabel heading = new JLabel("Client Management System");
        heading.setBounds(130, 40, 900, 80);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.WHITE);
        add(heading);
        ImageIcon i1 = new ImageIcon("Project/icons/splash.png"); // get image
        Image i2 = i1.getImage().getScaledInstance(650, 300, Image.SCALE_DEFAULT); // returns Image class obj
        ImageIcon i3 = new ImageIcon(i2); // image to ImageIcon
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 350); // left,top,len,width
        add(image);
        JButton click = new JButton("CLICK HERE");
        click.setBounds(100, 150, 200, 50);
        click.setBackground(Color.WHITE);
        click.setForeground(Color.BLACK);
        click.addActionListener(this);
        image.add(click);
        // screen
        setSize(900, 500);
        setLocation(200, 70);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String args[]) {
        new Splash();
    }
}
