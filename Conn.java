package Project;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "1234");

        } catch (Exception e) {
        }
    }
}

// JDBC Connectivity- Register driver class, create connection string, create
// statement, executing mysql queries, closing connections.
