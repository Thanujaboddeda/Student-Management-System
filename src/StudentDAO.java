import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) {
        String insertQuery = "INSERT INTO students (id, name, department, marks) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(insertQuery)) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getDepartment());
            ps.setDouble(4, s.getMarks());
            ps.executeUpdate();

            System.out.println("Student added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        String selectQuery = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(selectQuery)) {

            System.out.println("\nID | Name | Department | Marks");
            System.out.println("-------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("department") + " | " +
                                   rs.getDouble("marks"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
