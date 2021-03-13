import java.sql.*;

public class JDBCApp {
    public static void main (String args[]) {
        try {
            // Load a driver to connect to Derby (superfluous for JDBC 4)
            /* String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver); */
            // Create the connection string
            String url = "jdbc:derby:Music";
            // Obtain a connection with username con username and password
            Connection con = DriverManager.getConnection (url/* , "myUserName", "myPassword" */);
            // Create a Statement object to query the db
            Statement cmd = con.createStatement ();
            // Execute a query and store the results
            // in a ResultSet object
            String qry = "SELECT * FROM Album";
            ResultSet res = cmd.executeQuery(qry);
            // Print the results row by row
            while (res.next()) {
                System.out.printf("%s : %s (%s)\n", res.getString("Artist"), res.getString("Title"), res.getInt("Release_Year"));
            }
            res.close();
            cmd.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }  /* catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */
    }
}