import java.sql.*;

public class App {
    static final String DB_URL = "jdbc:mysql://localhost:3307/books";
    static final String USER = "root";
    static final String PASS = "";
    static final String QUERY = "INSERT INTO book VALUES (?,?,?,?)";
    static final String QUERY2 = "SELECT * FROM book";

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                PreparedStatement preparedStatement = conn.prepareStatement(QUERY);) {
            // Extract data from result set
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "GONE");
            preparedStatement.setString(3, "Michael Grant");
            preparedStatement.setDate(4, java.sql.Date.valueOf("2019-10-10"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}