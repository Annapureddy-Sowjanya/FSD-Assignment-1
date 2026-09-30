import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudent {

    public static void main(String[] args) {

        // Database connection details
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "Sowjanya@10";

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new course: ");
        String course = sc.nextLine();

        String sql = "UPDATE students SET course = ? WHERE id = ?";

        try {
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            // Prepare SQL statement
            PreparedStatement pst = con.prepareStatement(sql);

            // Set values
            pst.setString(1, course);
            pst.setInt(2, id);

            // Execute UPDATE
            int rows = pst.executeUpdate();

            if (rows > 0) {
                System.out.println("Student course updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

            // Close resources
            pst.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Database error occurred.");
            e.printStackTrace();
        }

        sc.close();
    }
}