import java.sql.*;

public class TryWithResources2 {
    public void selectFromDB() {
        try(Connection conn = 
            DriverManager.getConnection("url", "username", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PERSON ")) {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
}