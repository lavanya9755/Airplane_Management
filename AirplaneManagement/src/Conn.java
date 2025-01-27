import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            // Register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Build the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airplanemanagement", "root", "lavi9755");
            
            // Create statement
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
