package Servlet;

import DAO.UserDAO;
import Models.UserBean;
import Services.DateUtil;
import Services.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class SignUpServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("signup")){
            req.getSession().invalidate();
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String birth = req.getParameter("birth");
            String gender = req.getParameter("gender");
            boolean actived = false;

            boolean flag = UserDAO.checkAvailable(username);

            if (flag == false){
                String defaultPhoto = "default image";
                UserBean user = new UserBean(username, password, email, name, gender, birth, defaultPhoto, actived);
                user.setRandomCode(UUID.randomUUID().toString());
                user.setJoindate(DateUtil.getCurrentTime());
                UserDAO.insertUser(user);
                EmailUtil.sendAccountActiveEmail(user);
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher("registerSuccess.jsp").forward(req, resp);
            }else{
                String message = "This account has already existed, Please change another username!";
                req.getSession().setAttribute("errorMessage", message);
                req.getRequestDispatcher("signup.jsp").forward(req, resp);
            }
        }
    }
}
