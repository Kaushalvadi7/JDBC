import java.sql.*;
import java.util.Scanner;

public class dynamic_input
 {
   private static final String URL = "jdbc:mysql://localhost:3306/studentDB";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "Password";

   public static void main(String[] args) {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         String query =String.format("Insert into student12 VALUES(?, ?)");
         PreparedStatement preparedStatement = connection.prepareStatement(query);
         System.out.println("Connected to the database successfully!");

         Scanner scanner = new Scanner(System.in);
         while (true) { 
             System.out.println("Enter id");
             int id =scanner.nextInt();
             
             System.out.println("Enter Name");
             String name  = scanner.next();

             System.out.println("Enter more data(Y/N):");
             String choice =scanner.next();

             preparedStatement.setInt(1, id);
             preparedStatement.setString(2, name);

             preparedStatement.addBatch();
             if(choice.toUpperCase().equals("N")){
               break;
             }
         }
        int[] arr = preparedStatement.executeBatch();
        
         connection.close();
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

  }
