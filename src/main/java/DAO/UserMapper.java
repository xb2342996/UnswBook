package DAO;

import Models.UserBean;
import Models.NodeBean;

import java.util.List;

public interface UserMapper {
    public void insertUser(UserBean user);

    public UserBean getUser(String username);

    public List<UserBean> getAllUsers();

    public void updateUser(UserBean user);

    public void updateActivedUser(UserBean user);

    public void banUser(UserBean user);

    public List<UserBean> selectUserByUsername(String username);

    public List<UserBean> selectUsersByGender(String gender);

    public List<UserBean> selectUsersByBirth(String birth);

    public List<UserBean> selectUsersByName(String name);

    public List<UserBean> selectUsersByBirthandGender(String birth, String gender);

    public List<UserBean> selectUsersByNameandGender(String name, String gender);

    public List<UserBean> selectUsersByNameandBirth(String name, String birth);

    public List<UserBean> selectUsersByNameandBirthandGender(String name, String birth, String gender);

    public List<NodeBean> getUserInfo();
}
