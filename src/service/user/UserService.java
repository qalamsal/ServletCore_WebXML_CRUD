package service.user;

import entity.User;
import service.db.DbService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {

    public UserService(){
        DbService.connect();
    }

    public static boolean verifyLogin(String user, String pass) throws SQLException {
        String sql="select count(user_id) from tbluser where user_name='"+user+"'" +
                "and user_password='"+pass+"' and user_status=1";
        //System.out.println(sql);
        ResultSet resultSet = DbService.runSQL(sql);
        try {
            while(resultSet.next()){
                if(resultSet.getInt(1)==1)
                    return true;
                //System.out.println(resultSet.getInt(1));
            }
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public ArrayList<User> listUsers() throws SQLException {
        ArrayList<User> users=new ArrayList<User>();
        String sql="select * from tbluser";
        ResultSet resultSet = DbService.runSQL(sql);
        while(resultSet.next()){
            User user=new User();
            user.setId(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("user_name"));
            user.setPass(resultSet.getString("user_password"));
            user.setStatus(resultSet.getString("user_status"));
            users.add(user);
        }
        return users;
    }

    public String getPwdById(int id){
        return "password";
    }

}
