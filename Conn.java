package Project;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///clientmanagementsystem", "root", "1234");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// JDBC Connectivity- Register driver class, create connection string, create
// statement, executing mysql queries, closing connections.
