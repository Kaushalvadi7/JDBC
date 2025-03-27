import java.sql.*;


public class Crud_operation {
   private static final String url = "jdbc:mysql://localhost:3306/studentDB";
   private static final  String username = "root";
   private  static final  String password = "Password";
   public static void main(String[] args) {

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(url, username, password);
         System.out.println("Connected to the database successfully!");
         
         Statement statement = connection.createStatement();
         //Insert
         // String query = String.format("INSERT INTO student12(id, name) VALUES(%o, '%s')", 11, "Renish");
         // int rowsAffected = statement.executeUpdate(query);
         // if(rowsAffected> 0){
         //    System.out.println("Data Inserted Successfully");
         // } else{
         //    System.out.println("Data Not Inserted!");
         // }
         
         //update
         // String query = String.format("UPDATE student12 SET name = '%s' WHERE name = '%s'", "Harsh","jyom");

         // int rowsAffected = statement.executeUpdate(query);
         // if(rowsAffected> 0){
         //    System.out.println("Data update Successfully");
         // } else{
         //    System.out.println("Data Not Updated!");
         // }
         
         //Delete
         String query = String.format("DELETE FROM student12 WHERE ID =11");

         int rowsAffected = statement.executeUpdate(query);
         if(rowsAffected> 0){
            System.out.println("Delete Successfully");
         } else{
            System.out.println("Not Deleted!");
         }
         
         connection.close();
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
      
   }
}
