package Servlet;

import DAO.FriendDAO;
import Models.UserBean;
import Services.EmailUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
                EmailUtil.sendAddFriendEmail(user.getEmail(), friendEmail, user.getUsername(), friendName);
                req.getRequestDispatcher("searchResult.jsp").forward(req,resp);
            }
        }else if (action.equals("addConfirm")){
            String username = req.getParameter("username");
            String friendname = req.getParameter("friendname");
            FriendDAO.addFriend(username, friendname);
            req.getSession().setAttribute("friendname",username);
            req.getRequestDispatcher("addFriendSuccess.jsp").forward(req, resp);
        }
    }
}
