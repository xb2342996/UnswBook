package DAO;

import Models.UserBean;

import java.util.List;

public interface UserMapper {
    public void insertUser(UserBean user);

    public UserBean getUser(String username);

    public List<UserBean> getAllUsers();

    public void updateUser(UserBean user);

    public void updateActivedUser(UserBean user);

    public void banUser(UserBean user);
}
