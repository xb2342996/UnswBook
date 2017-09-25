package Servlet;

import DAO.MessageDAO;
import DAO.UserDAO;
import Models.MessageBean;
import Models.UserBean;
import Services.EmailUtil;
import Services.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")){
            req.getSession().invalidate();
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            Login loginEvent = new Login();
            UserBean user = UserDAO.getUser(username);

            if (user != null){
                boolean passwordFlag = loginEvent.passwordCheck(user, password);
                boolean activeFlag = loginEvent.activeCheck(user);
                if (activeFlag){
                    if (passwordFlag){

                        List<MessageBean> results = MessageDAO.getAllMessages(user.getUsername());

                        req.getSession().setAttribute("allMessages", results);
                        req.getSession().setAttribute("userInfo", user);
                        req.getRequestDispatcher("home.jsp").forward(req, resp);
                    }else {
                        String message = "The username and password you entered did not match our records. Please double-check and try again.";

                        req.getSession().setAttribute("errorMessage", message);
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                    }
                }else {
                    String message = "This account isn't active, Please check your E-mail!";

                    req.getSession().setAttribute("errorMessage", message);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }

            }else {
                String message = "This account doesn't exist, Please sign up!";

                req.getSession().setAttribute("errorMessage", message);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        }else if(action.equals("adminLogin")){
            req.getSession().invalidate();
            String admin = req.getParameter("username");
            String adminpwd = req.getParameter("password");
            if (admin.equals("admin") && adminpwd.equals("password")){
                List<UserBean> results = UserDAO.selectAllUsers();
                req.getSession().setAttribute("allUsers", results);
                resp.getWriter().write("success");
            }else {
                resp.getWriter().write("failure");
            }
        }
    }
}
