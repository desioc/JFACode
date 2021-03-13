package application.db.utility;
public interface SQLConstants {
    String GET_ALL_USERS = "SELECT * FROM USERS";
    String GET_USER = "SELECT * FROM USERS WHERE ID = ?";
    // Other constants...
}