package Servlet;

import DAO.MessageDAO;
import Models.MessageBean;
import Models.UserBean;
import Services.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action.equals("message")){
            //插入消息到数据库
            String messageString = req.getParameter("message");
            UserBean user = (UserBean)req.getSession().getAttribute("userInfo");


            String username = user.getUsername();
            String uuid = UUID.randomUUID().toString();

            MessageBean message = new MessageBean(uuid, username, messageString, DateUtil.getCurrentTime());
            MessageDAO.insertMessage(message);

            //获取所有消息 返回主页
            List<MessageBean> results = MessageDAO.getAllMessages(username);
            resp.getWriter().write("Send Successfully");
            req.getSession().setAttribute("allMessages", results);
//            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
