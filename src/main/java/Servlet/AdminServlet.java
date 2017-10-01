package Servlet;

import DAO.UserDAO;
import Models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String flag = req.getParameter("flag");
        System.out.println(username+flag);
        UserBean user = UserDAO.getUser(username);

        if (flag.equals("Active")){
            user.setActived(false);
            UserDAO.banUser(user);
        }else if (flag.equals("Ban")){
            user.setActived(true);
            UserDAO.banUser(user);
        }
    }
}
