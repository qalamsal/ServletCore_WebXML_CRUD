package servlets;

import service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        System.out.println("GET METHOD");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        System.out.println("Form Posted");
        String user=req.getParameter("email-address");
        //System.out.println(user);
        String pass=req.getParameter("password");
        UserService userService=new UserService();
        boolean isUserValid= false;
        try {
            isUserValid = UserService.verifyLogin(user,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //user
        //String user="sandesh";
        //String pass="lamsal;

        //isUserValid = welcome.jsp
        if(isUserValid==true)
            resp.sendRedirect("dashboard.jsp");
        else
            resp.sendRedirect("frmlogin.jsp?msg=error");
        //invalid login.jsp (retry ... Message)
    }
}
