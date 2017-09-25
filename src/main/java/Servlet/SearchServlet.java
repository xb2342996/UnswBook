package Servlet;

import DAO.FriendDAO;
import DAO.UserDAO;
import Models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchName = req.getParameter("searchFriend");
        UserBean user = (UserBean) req.getSession().getAttribute("userInfo");
        UserBean searchedUser = UserDAO.getUser(searchName);
        if (searchedUser != null) {
            boolean friendFlag = FriendDAO.isFriend(user.getUsername(), searchName);
            req.getSession().setAttribute("searchResult", searchedUser);
            System.out.println(friendFlag);
            req.getSession().setAttribute("friendFlag", friendFlag);
            req.getRequestDispatcher("searchResult.jsp").forward(req, resp);
        }else {
            String errorMessage = "This user does not exist!";
            req.getSession().setAttribute("searchError", errorMessage);
            req.getRequestDispatcher("searchResult.jsp").forward(req, resp);
        }
    }
}
