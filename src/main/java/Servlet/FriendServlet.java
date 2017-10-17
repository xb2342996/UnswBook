package Servlet;

import DAO.FriendDAO;
import DAO.NotificationDAO;
import DAO.ReportDAO;
import Models.Activity;
import Models.NotificationBean;
import Models.UserBean;
import Services.DateUtil;
import Services.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class FriendServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("addFriend")) {
            String flag = req.getParameter("flag");

            String friendEmail = req.getParameter("friendEmail");
            String friendName = req.getParameter("friendName");
            UserBean user = (UserBean) req.getSession().getAttribute("userInfo");
            if (flag.equals("false")) {

                String operation = user.getUsername()+ " sent a friend request to" + friendName + ".";
                ReportDAO.addActivity(new Activity(UUID.randomUUID().toString(),user.getUsername(), DateUtil.getCurrentTime(),operation));
                EmailUtil.sendAddFriendEmail(user.getEmail(), friendEmail, user.getUsername(), friendName);
                req.getRequestDispatcher("searchResult.jsp").forward(req,resp);
            }
        }else if (action.equals("addConfirm")){

            String username = req.getParameter("username");
            String friendname = req.getParameter("friendname");
            if (username != null && friendname != null) {

                FriendDAO.addFriend(username, friendname);

                String content = friendname + " has confirmed your friend request, now you are friends!";
                NotificationBean noti = new NotificationBean(UUID.randomUUID().toString(), friendname, username, DateUtil.getCurrentTime(), content);
                NotificationDAO.addNotification(noti);

                String operation = friendname+ " confirmed "+username+"'s friend request.";
                ReportDAO.addActivity(new Activity(UUID.randomUUID().toString(),friendname, DateUtil.getCurrentTime(),operation));

                req.getSession().setAttribute("friendname", username);
                req.getRequestDispatcher("addFriendSuccess.jsp").forward(req, resp);
            }
        }
    }
}
