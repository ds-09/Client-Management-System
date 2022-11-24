package Project;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateClient extends JFrame implements ActionListener {

    JTextField tfName, tfEmail, tfContact, tfMembershipID, tfAddress;
    JLabel lblMembershipID;
    JButton add2, back;
    String MembershipID;

    UpdateClient(String MembershipID) {
        this.MembershipID = MembershipID;
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setForeground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Client Details");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        labelname.setForeground(Color.WHITE);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        lblname.setForeground(Color.WHITE);
        add(lblname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        labeldob.setForeground(Color.WHITE);
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        lbldob.setForeground(Color.WHITE);
        add(lbldob);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        labeladdress.setForeground(Color.WHITE);
        add(labeladdress);

        tfAddress = new JTextField();
        tfAddress.setBounds(200, 250, 150, 30);
        add(tfAddress);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        labelemail.setForeground(Color.WHITE);
        add(labelemail);

        tfEmail = new JTextField();
        tfEmail.setBounds(200, 300, 150, 30);
        add(tfEmail);

        JLabel labelcontact = new JLabel("Contact");
        labelcontact.setBounds(50, 350, 150, 30);
        labelcontact.setFont(new Font("serif", Font.PLAIN, 20));
        labelcontact.setForeground(Color.WHITE);
        add(labelcontact);

        tfContact = new JTextField();
        tfContact.setBounds(200, 350, 150, 30);
        add(tfContact);

        JLabel labelmembershipID = new JLabel("Membership ID");
        labelmembershipID.setBounds(50, 400, 150, 30);
        labelmembershipID.setFont(new Font("serif", Font.PLAIN, 20));
        labelmembershipID.setForeground(Color.WHITE);
        add(labelmembershipID);

        lblMembershipID = new JLabel();
        lblMembershipID.setBounds(200, 400, 150, 30);
        lblMembershipID.setFont(new Font("serif", Font.PLAIN, 20));
        lblMembershipID.setForeground(Color.WHITE);
        add(lblMembershipID);

        try {
            Conn c = new Conn();
            String query = "select * from client where MembershipID = '" + MembershipID + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lbldob.setText(rs.getString("dob"));
                tfAddress.setText(rs.getString("address"));
                tfContact.setText(rs.getString("contact"));
                tfEmail.setText(rs.getString("email"));
                lblMembershipID.setText(rs.getString("MembershipID"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add2 = new JButton("Update Details");
        add2.setBounds(250, 480, 150, 40);
        add2.addActionListener(this);
        add2.setBackground(Color.BLACK);
        add2.setForeground(Color.WHITE);
        add(add2);

        back = new JButton("Back");
        back.setBounds(450, 480, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        ImageIcon i1 = new ImageIcon("Project/icons/view.png"); // get image
        Image i2 = i1.getImage().getScaledInstance(370, 240, Image.SCALE_DEFAULT); // returns Image class obj
        ImageIcon i3 = new ImageIcon(i2); // image to ImageIcon
        JLabel image = new JLabel(i3);
        image.setBounds(150, 120, 1050, 350); // left,top,len,width
        add(image);

        setSize(900, 580);
        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add2) {
            String address = tfAddress.getText();
            String contact = tfContact.getText();
            String email = tfEmail.getText();

            try {
                Conn conn = new Conn();
                String query = "update client set address = '"
                        + address + "', contact = '" + contact + "', email =  '" + email + "' where MembershipID= '"
                        + MembershipID + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully.");
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

    public static void main(String[] args) {
        new UpdateClient("");
    }
}