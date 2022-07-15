import java.sql.*;

public class JavaMysqlSelectExample {
        static final String DB_URL = "jdbc:postgresql://localhost:5432/sette_clipping_database";
        static final String USER = "postgres";
        static final String PASS = "#Mance790ab#";
        static final String QUERY = "SELECT return_clips_by_tag()";

        public static void main(String[] args) {
            // Open a connection
            try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
            ) {
                while(rs.next()){
                    //Display values
                    System.out.print("tag_name_c" + rs.getString("tag_name_c"));
                    System.out.print(", num_of_tag: " + rs.getInt("num_of_tag"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }