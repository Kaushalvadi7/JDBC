import java.sql.*;

public class BatchProcessingExample {
    private static final String url = "jdbc:mysql://localhost:3306/studentDB";
    private static final String username = "root";
    private static final String password = "Password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            
            connection.setAutoCommit(false);  

            statement.addBatch("INSERT INTO student12 (id, name) VALUES (12, 'Akshay')");
            statement.addBatch("INSERT INTO student12 (id, name) VALUES (13, 'Bhavya')");
            statement.addBatch("INSERT INTO student12 (id, name) VALUES (14, 'Champak')");

            int[] rowsAffected = statement.executeBatch();
            
            connection.commit(); 
            System.out.println("Batch Insert Successful!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
