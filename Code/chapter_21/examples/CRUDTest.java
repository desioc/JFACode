import java .sql.*;
public class CRUDTest {
    public static void main(String args[]) {
         try (Connection conn = DriverManager.getConnection("jdbc:derby:Music");
                 Statement stmt = conn.createStatement())   {      
                 printResultSet(stmt);
            Album album = new Album(5,"Led Zeppelin", "Led Zeppelin IV", 1971);
            inserisciAlbum(stmt, album);
            printResultSet(stmt);
            album.setTitle("Led Zeppelin III");
            updateAlbum(stmt, album);
            printResultSet(stmt);
            deleteAlbum(stmt, album);
            printResultSet(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public static int inserisciAlbum(Statement stmt, Album album) throws SQLException  {
        String insertStatement = String.format("INSERT INTO ALBUM (AlbumId, Title, Artist, Release_Year) VALUES (%s,'%s','%s',%s)", album.getAlbumId(), album.getArtist(), album.getTitle(), album.getReleaseYear());
        System.out.println(insertStatement);
        return stmt.executeUpdate(insertStatement);
    }
   
    public static int updateAlbum(Statement stmt, Album album) throws SQLException  {
        String updateStatement = String.format("UPDATE  ALBUM set Title='%s', Artist='%s', Release_Year=%s WHERE AlbumId = %s", album.getArtist(), album.getTitle(), album.getReleaseYear(), album.getAlbumId());
        System.out.println(updateStatement);
        return stmt.executeUpdate(updateStatement);
    }
    
     public static int deleteAlbum(Statement stmt, Album album) throws SQLException  {
        String deleteStatement = String.format("DELETE FROM  ALBUM  WHERE AlbumId = %s", album.getAlbumId());
        System.out.println(deleteStatement);
        return stmt.executeUpdate(deleteStatement);
    }
    
    public static void printResultSet( Statement stmt) throws SQLException{
        try (ResultSet res = stmt.executeQuery("SELECT * FROM Album")) {
            while (res.next()) {
                System.out.printf("%s : %s (%s)\n", res.getString("Artist"), res.getString("Title"), res.getInt("Release_Year"));
            }
        }
    }
}