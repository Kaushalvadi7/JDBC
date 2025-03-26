import java.sql.*;

public class Crud_prepare_statement
 {
   private static final String URL = "jdbc:mysql://localhost:3306/studentDB";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "Password";

   public static void main(String[] args) {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         System.out.println("Connected to the database successfully!");

         insertStudent(connection, 7, "Ram");
         updateStudent(connection, "jenish", "jyot");
         deleteStudent(connection, 11);
         dataFetchFromStudent(connection);
      

         connection.close();
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

   private static void insertStudent(Connection connection, int id, String name) throws SQLException {
      String query = "INSERT INTO student12 (id, name) VALUES (?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      preparedStatement.setString(2, name);
      int rowsAffected = preparedStatement.executeUpdate();
      System.out.println(rowsAffected > 0 ? "Data Inserted Successfully!" : "Data Not Inserted!");
      preparedStatement.close();
   }

   private static void updateStudent(Connection connection, String oldName, String newName) throws SQLException {
      String query = "UPDATE student12 SET name = ? WHERE name = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setString(1, newName);
      preparedStatement.setString(2, oldName);
      int rowsAffected = preparedStatement.executeUpdate();
      System.out.println(rowsAffected > 0 ? "Data Updated Successfully!" : "Data Not Updated!");
      preparedStatement.close();
   }

   private static void deleteStudent(Connection connection, int id) throws SQLException {
      String query = "DELETE FROM student12 WHERE id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setInt(1, id);
      int rowsAffected = preparedStatement.executeUpdate();
      System.out.println(rowsAffected > 0 ? "Data Deleted Successfully!" : "Data Not Deleted!");
      preparedStatement.close();
   }
   
   private static void dataFetchFromStudent(Connection connection) throws SQLException {
      String query = "SELECT * FROM student12";

      PreparedStatement preparedStatement = connection.prepareStatement(query);
      
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
         int id =resultSet.getInt("id");
         String name = resultSet.getString("name");

         System.out.println("ID:" + id + ", Name: " + name);
      }

      resultSet.close();
      preparedStatement.close();
   }

}
