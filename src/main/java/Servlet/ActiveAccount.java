package Servlet;

import DAO.MessageDAO;
import DAO.ReportDAO;
import DAO.UserDAO;
import Models.Activity;
import Models.MessageBean;
import Models.UserBean;
import Services.DateUtil;
import Services.GenerateLinkUtil;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class ActiveAccount extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserBean user = UserDAO.getUser(username);
        String code = req.getParameter("checkCode");
        user.setActived(GenerateLinkUtil.verifyCheckcode(user,code));
        UserDAO.updateUser(user);
        UserDAO.getUser(user.getUsername());
        String gender = user.getGender().equals("male") ? "his" : "her";
        String operation = user.getUsername()+ " actived "+gender+" account.";
        ReportDAO.addActivity(new Activity(UUID.randomUUID().toString(),user.getUsername(), DateUtil.getCurrentTime(),operation));
        List<MessageBean> results = MessageDAO.getAllMessages(user.getUsername());

        req.getSession().setAttribute("allMessages", results);
        req.getSession().setAttribute("userInfo",user);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
