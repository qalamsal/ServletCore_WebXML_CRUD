package service.db;

import java.sql.*;

public class DbService {

    static String dbUser="root";
    static String dbPass="root";

    static String connString="jdbc:mysql://localhost:3306/dbuser";
    static Connection con=null;


    public static boolean connect(){
        try {
            con= DriverManager.getConnection(connString,dbUser,dbPass);
            System.out.println("Db Connected !");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Some Thing went Wrong , Connecting DB ");
        }
        return true;
    }

    public static ResultSet runSQL(String query) throws SQLException {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            return rs;
    }
}

