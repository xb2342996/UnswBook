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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

            UserBean user = (UserBean) req.getSession().getAttribute("userInfo");
            if (!password.equals("") && password != null){
                user.setPassword(password);
            }
            if (!email.equals("") && email != null){
                user.setEmail(email);
            }
            if (!name.equals("") && name != null){
                user.setName(name);
            }
            if (!birth.equals("") && birth != null){
                user.setBirth(birth);
            }
            if (!gender.equals("") && gender != null){
                user.setGender(gender);
            }
            if (!photo.equals("") && photo != null){
                user.setPhoto(photo);
            }

            UserDAO.updateActivedUser(user);

            req.getSession().setAttribute("userInfo", user);
            String message = "success";
            resp.getWriter().write(message);
//            req.getRequestDispatcher("profile.jsp").forward(req, resp);
        }
    }
}
