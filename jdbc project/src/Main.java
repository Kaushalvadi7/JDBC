import java.sql.*;


public class Main {
   private static final String url = "jdbc:mysql://localhost:3306/studentDB";
   private static final  String username = "root";
   private  static final  String password = "Password";
   public static void main(String[] args) {

      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(url, username, password);
         System.out.println("Connected to the database successfully!");
         
         java.sql.Statement Statement = connection.createStatement();
         String query = "SELECT * FROM student;";
         ResultSet resultset = Statement.executeQuery(query);

         while (resultset.next()) {
         int student_id = resultset.getInt("student_id");
         String name  = resultset.getString("name");
         int age = resultset.getInt("age");
         String email  = resultset.getString("email");
         String department  = resultset.getString("department");
         Date enrollment_date = resultset.getDate("enrollment_date");

         System.out.print("Student_id:" + student_id + " ");
         System.out.print("Name:" + name+ " ");
         System.out.print("Age:" + age+ " ");
         System.out.print("Email:" + email+ " ");
         System.out.print("Department:" + department+ " ");
         System.out.print("Enrollment_Date:" + enrollment_date + "\n");
         }

         connection.close();
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }

   }
}
