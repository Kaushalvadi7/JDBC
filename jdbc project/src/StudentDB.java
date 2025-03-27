import java.sql.*;

public class StudentDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentDB"; 
        String user = "root"; 
        String password = "Password"; 

        try (Connection conn = DriverManager.getConnection(url, user, password); 
        Statement stmt = conn.createStatement()) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            String createTable = "CREATE TABLE IF NOT EXISTS STUDENT12 ("
                    + "ID INT PRIMARY KEY, "
                    + "NAME VARCHAR(10))";
            stmt.executeUpdate(createTable);
            System.out.println("Table STUDENT12 created successfully!");

            stmt.addBatch("INSERT INTO STUDENT12 (ID, NAME) VALUES (3, 'Rishav')");
            stmt.addBatch("INSERT INTO STUDENT12 (ID, NAME) VALUES (4, 'Fenil')");
            stmt.addBatch("INSERT INTO STUDENT12 (ID, NAME) VALUES (5, 'Rohit')");
            stmt.addBatch("INSERT INTO STUDENT12 (ID, NAME) VALUES (6, 'Raj')");
            stmt.addBatch("INSERT INTO STUDENT12 (ID, NAME) VALUES (7, 'Raman')");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to MySQL.");
            e.printStackTrace();
        }
    }
}
