package Servlet;

import DAO.MessageDAO;
import DAO.UserDAO;
import Models.MessageBean;
import Models.UserBean;
import Services.GenerateLinkUtil;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ActiveAccount extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserBean user = UserDAO.getUser(username);
        String code = req.getParameter("checkCode");
        user.setActived(GenerateLinkUtil.verifyCheckcode(user,code));
        UserDAO.updateUser(user);
        UserDAO.getUser(user.getUsername());
        List<MessageBean> results = MessageDAO.getAllMessages(user.getUsername());

        req.getSession().setAttribute("allMessages", results);
        req.getSession().setAttribute("userInfo",user);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
