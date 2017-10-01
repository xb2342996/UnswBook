package Servlet;

import DAO.NotificationDAO;
import Models.NotificationBean;
import Models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Notification extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean user = (UserBean)req.getSession().getAttribute("userInfo");
        System.out.println(user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        UserBean user = (UserBean)req.getSession().getAttribute("userInfo");
        List<NotificationBean> notiList = null;
        if (action.equals("friend")) {
            notiList = NotificationDAO.getNotificationByType(user.getUsername(), "friend");
            if (notiList.size()>0 && user != null) {
                for (NotificationBean noti : notiList ) {
                    resp.getWriter().write(noti.getContent());
                    NotificationDAO.deleteNotification(noti);
                }
            }
        }else if (action.equals("like")){
            notiList = NotificationDAO.getNotificationByType(user.getUsername(), "like");
            if (notiList.size()>0 && user != null) {
                int i = 0;
                for (NotificationBean noti: notiList) {
                    i++;
                    resp.getWriter().write(noti.getContent());
                    NotificationDAO.deleteNotification(noti);
                }
            }

        }
    }
}
