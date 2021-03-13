package application.db.logic;
//import application.db.utility.*; /*cases 1 e 2*/
import static application.db.utility.SQLConstants.*;
import java.sql.*;
import java.util.*;

public class DBManager /*implements SQLConstants*/ /*case 1*/{
    public Collection getUsers() throws SQLException{
        Collection users = null;
        Statement statement = null;
        //...
        //ResultSet rs = statement.executeQuery(GET_ALL_USERS);/*case 1*/
        //ResultSet rs = statement.executeQuery(SQLConstants.GET_ALL_USERS);/*case 2*/
        ResultSet rs = statement.executeQuery(GET_ALL_USERS);/*case 3*/
        //...
        return users;
    }
    // Other methods...
}