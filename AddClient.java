package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClient extends JFrame implements ActionListener {

    JTextField tfName, tfEmail, tfContact, tfMembershipID, tfAddress;
    com.toedter.calendar.JDateChooser dcDOB;

    JButton add1, back;

    AddClient() {
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);

        JLabel heading = new JLabel("Enter Client Details");
        heading.setBounds(270, 35, 400, 50);
        heading.setFont(new Font("serif", Font.BOLD, 40));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel lName = new JLabel("Name");
        lName.setBounds(50, 150, 60, 25);
        lName.setFont(new Font("serif", Font.PLAIN, 22));
        lName.setForeground(Color.WHITE);
        add(lName);

        tfName = new JTextField();
        tfName.setBounds(200, 150, 300, 25);
        add(tfName);

        JLabel lDOB = new JLabel("DOB");
        lDOB.setBounds(50, 180, 90, 25);
        lDOB.setFont(new Font("serif", Font.PLAIN, 22));
        lDOB.setForeground(Color.WHITE);
        add(lDOB);

        dcDOB = new com.toedter.calendar.JDateChooser();
        dcDOB.setBounds(200, 180, 300, 25);
        add(dcDOB);

        JLabel lMembershipID = new JLabel("MembershipID");
        lMembershipID.setBounds(50, 210, 150, 25);
        lMembershipID.setFont(new Font("serif", Font.PLAIN, 20));
        lMembershipID.setForeground(Color.WHITE);
        add(lMembershipID);

        tfMembershipID = new JTextField();
        tfMembershipID.setBounds(200, 210, 300, 25);
        add(tfMembershipID);

        JLabel lContact = new JLabel("Contact No.");
        lContact.setBounds(50, 240, 150, 25);
        lContact.setFont(new Font("serif", Font.PLAIN, 20));
        lContact.setForeground(Color.WHITE);
        add(lContact);

        tfContact = new JTextField();
        tfContact.setBounds(200, 240, 300, 25);
        add(tfContact);

        JLabel lEmail = new JLabel("E-Mail");
        lEmail.setBounds(50, 270, 150, 25);
        lEmail.setFont(new Font("serif", Font.PLAIN, 20));
        lEmail.setForeground(Color.WHITE);
        add(lEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 270, 300, 25);
        add(tfEmail);

        JLabel lAddress = new JLabel("Address");
        lAddress.setBounds(50, 300, 150, 25);
        lAddress.setFont(new Font("serif", Font.PLAIN, 20));
        lAddress.setForeground(Color.WHITE);
        add(lAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 300, 300, 25);
        add(tfAddress);

        ImageIcon i1 = new ImageIcon("Project/icons/add.png"); // get image
        Image i2 = i1.getImage().getScaledInstance(370, 240, Image.SCALE_DEFAULT); // returns Image class obj
        ImageIcon i3 = new ImageIcon(i2); // image to ImageIcon
        JLabel image = new JLabel(i3);
        image.setBounds(190, 120, 1050, 350); // left,top,len,width
        add(image);

        add1 = new JButton("Add");
        add1.setBounds(150, 370, 100, 40);
        add1.addActionListener(this);
        add1.setBackground(Color.BLACK);
        add1.setForeground(Color.WHITE);
        add(add1);

        back = new JButton("Back");
        back.setBounds(270, 370, 100, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(950, 500);
        setLocation(200, 70);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add1) {

            String name = tfName.getText();
            String dob = ((JTextField) dcDOB.getDateEditor().getUiComponent()).getText();
            String membershipID = tfMembershipID.getText();
            String contact = tfContact.getText();
            String email = tfEmail.getText();
            String address = tfAddress.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into client values('" + name + "', '" + dob + "', '" + membershipID + "', '"
                        + contact + "', '" + email + "'" + address + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully.");
                setVisible(false);
                new Home();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String args[]) {
        new AddClient();
    }

}
