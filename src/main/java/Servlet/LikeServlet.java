package Servlet;

import DAO.LikeDAO;
import DAO.NotificationDAO;
import DAO.ReportDAO;
import Models.Activity;
import Models.NotificationBean;
import Models.UserBean;
import Services.DateUtil;

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

            String content = user.getUsername()+" has liked your message!";
            NotificationBean noti = new NotificationBean(UUID.randomUUID().toString(),user.getUsername(),friend, DateUtil.getCurrentTime(),content);
            NotificationDAO.addNotification(noti);

            String operation = user.getUsername()+ " liked "+ friend +"'s message.";
            ReportDAO.addActivity(new Activity(UUID.randomUUID().toString(),user.getUsername(), DateUtil.getCurrentTime(),operation));
        }
    }
}
