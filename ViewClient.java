package Project;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewClient extends JFrame implements ActionListener {

    JTable table;
    Choice cMembershipID;
    JButton search, print, update, back;

    ViewClient() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl = new JLabel("Search by MembershipID");
        searchlbl.setBounds(20, 20, 150, 50);
        add(searchlbl);

        cMembershipID = new Choice();
        cMembershipID.setBounds(200, 35, 150, 50);
        add(cMembershipID);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Client");
            while (rs.next()) {
                cMembershipID.add(rs.getString("MembershipID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Client");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900, 500);
        setLocation(200, 70);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from Client where MembershipID = '" + cMembershipID.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateClient(cMembershipID.getSelectedItem());
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewClient();
    }
}
