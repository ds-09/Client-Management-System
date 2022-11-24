package Project;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveClient extends JFrame implements ActionListener {

    Choice cMembershipID;
    JButton delete, back;

    RemoveClient() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Remove Client");
        heading.setBounds(220, 20, 500, 40);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        add(heading);

        JLabel labelmembershipID = new JLabel("Membership ID");
        labelmembershipID.setBounds(50, 100, 100, 30);
        add(labelmembershipID);

        cMembershipID = new Choice();
        cMembershipID.setBounds(200, 105, 100, 30);
        add(cMembershipID);

        try {
            Conn c = new Conn();
            String query = "select * from client";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cMembershipID.add(rs.getString("MembershipID"));
            }
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 130, 100, 30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 130, 100, 30);
        add(lblname);

        JLabel labelContact = new JLabel("Contact");
        labelContact.setBounds(50, 160, 100, 30);
        add(labelContact);

        JLabel lblcontact = new JLabel();
        lblcontact.setBounds(200, 160, 100, 30);
        add(lblcontact);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 190, 100, 30);
        add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 190, 150, 30);
        add(lblemail);

        try {
            Conn c = new Conn();
            String query = "select * from client where MembershipID = '" + cMembershipID.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblcontact.setText(rs.getString("contact"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cMembershipID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from client where MembershipID = '" + cMembershipID.getSelectedItem()
                            + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {

                        lblname.setText(rs.getString("name"));
                        lblcontact.setText(rs.getString("contact"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(100, 250, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(260, 250, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon("Project/icons/delete.png"); // get image
        Image i2 = i1.getImage().getScaledInstance(370, 240, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2); // image to ImageIcon
        JLabel image = new JLabel(i3);
        image.setBounds(120, 0, 1050, 350); // left,top,len,width
        add(image);

        setSize(700, 400);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from client where MembershipID = '" + cMembershipID.getSelectedItem() + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Client Information Deleted Sucessfully");
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
        new RemoveClient();
    }
}
