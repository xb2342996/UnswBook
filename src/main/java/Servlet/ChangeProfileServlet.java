package Servlet;

import DAO.UserDAO;
import Models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        if (action.equals("profile")){

            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String birth = req.getParameter("birth");
            String gender = req.getParameter("gender");
            String photo = "this is an another picture";

            UserBean user = new UserBean(username,password,email,name,gender,birth,photo);
            UserDAO.updateActivedUser(user);

            String message = "Update Successfully!";
            req.getSession().setAttribute("message", message);
            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        }
    }
}
