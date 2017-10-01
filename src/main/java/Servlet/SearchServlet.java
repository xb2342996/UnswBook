package Servlet;

import DAO.FriendDAO;
import DAO.UserDAO;
import Models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        UserBean user = (UserBean) req.getSession().getAttribute("userInfo");
        if (action.equals("searchFriend")) {
            String searchName = req.getParameter("searchFriend");

            List<UserBean> results = UserDAO.selectUserByUsername(searchName);

            responseSearch(results, user, req, resp);
        }else if(action.equals("searchUser")){
            String searchName = req.getParameter("searchUser");
            if (searchName.equals("")) {

                req.getSession().setAttribute("searchUserResult", null);
                req.getRequestDispatcher("adminControl.jsp").forward(req, resp);

            }else {

                ArrayList<UserBean> result = new ArrayList<UserBean>();
                UserBean searchedUser = UserDAO.getUser(searchName);

                if (searchedUser != null) {
                    result.add(searchedUser);
                    req.getSession().setAttribute("searchUserResult", result);
//                    req.getRequestDispatcher("adminControl.jsp").forward(req, resp);
                    resp.getWriter().write("success");
                } else {
//                    req.getSession().setAttribute("searchUserResult", null);
//                    req.getSession().setAttribute("errorMessage", "This user does not exists!");
//                    req.getRequestDispatcher("adminControl.jsp").forward(req, resp);
                    resp.getWriter().write("failure");
                }
            }
        }else if(action.equals("advancedSearchFriend")){
            String name = req.getParameter("friendName");
            String birth = req.getParameter("friendBirth");
            String gender = req.getParameter("friendGender");
            List<UserBean> results = null;
            if (name.equals("") && birth.equals("") && !gender.equals("")){ //select gender
                results = UserDAO.selectUsersByGender(gender);
            }else if (!name.equals("") && birth.equals("") && gender.equals("")){ //select name
                results = UserDAO.selectUsersByName(name);
            }else if (name.equals("") && !birth.equals("") && gender.equals("")) { //select birth
                results = UserDAO.selectUsersByBirth(birth);
            }else if (!name.equals("") && !birth.equals("") && gender.equals("")) { //select name and birth
                results = UserDAO.selectUsersByNameandBirth(name, birth);
            }else if (!name.equals("") && birth.equals("") && !gender.equals("")) { //select name and gender
                results = UserDAO.selectUsersByNameandGender(name,gender);
            }else if (name.equals("") && !birth.equals("") && !gender.equals("")) { //select gender and birth
                results = UserDAO.selectUsersByBirthandGender(birth,gender);
            }else if (!name.equals("") && !birth.equals("") && !gender.equals("")) { //select name gender and birth
                results = UserDAO.selectUsersByNameandBirthandGender(name,birth,gender);
            }

            responseSearch(results, user, req, resp);
        }
    }
    private ArrayList<UserBean> checkFriend(List<UserBean> results, String username){
        ArrayList<UserBean> friends = new ArrayList<UserBean>();
        for (UserBean friend: results) {
            boolean friendFlag = FriendDAO.isFriend(username, friend.getUsername());
            friend.setFriend(friendFlag);
            friends.add(friend);
        }
        return friends;
    }
    private void responseSearch(List<UserBean> results, UserBean user,HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        if (results.size() > 0 && results != null) {
            ArrayList<UserBean> searchResults = checkFriend(results, user.getUsername());
            req.getSession().setAttribute("searchResult", searchResults);
            resp.getWriter().write("success");
//            req.getRequestDispatcher("searchResult.jsp").forward(req, resp);
        } else {
            String errorMessage = "The user does not exist!";
//            req.getSession().setAttribute("searchError", errorMessage);
//            req.getRequestDispatcher("searchResult.jsp").forward(req, resp);
            resp.getWriter().write(errorMessage);
        }
    }
}
