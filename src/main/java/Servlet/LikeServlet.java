package Servlet;

import DAO.LikeDAO;
import DAO.NotificationDAO;
import Models.NotificationBean;
import Models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class LikeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("messageId");
        String flag = req.getParameter("flag");
        String friend = req.getParameter("friend");
        UserBean user = (UserBean)req.getSession().getAttribute("userInfo");
        if (flag.equals("Like")){
            LikeDAO.unlike(user.getUsername(), id);
        }else {
            LikeDAO.like(user.getUsername(), id);
            String content = user.getUsername()+" liked your posted message!";
            NotificationBean noti = new NotificationBean(UUID.randomUUID().toString(),user.getUsername(),friend,"like",content);
            NotificationDAO.addNotification(noti);
        }


    }
}
