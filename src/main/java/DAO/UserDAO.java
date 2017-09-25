package DAO;

import Models.UserBean;
import Services.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;


import java.util.List;

public class UserDAO {

    public static boolean checkAvailable(String username){

        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean result = mapper.getUser(username);
        if (result != null){
            session.close();
            return true;
        }
        return false;
    }
    public static UserBean getUser(String username){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserBean result = mapper.getUser(username);

        return result;
    }
    public static void insertUser(UserBean user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.insertUser(user);
            session.commit();
            session.close();
            System.out.println("插入成功");
        }catch (Exception e){
            System.out.println("插入失败");
        }
    }
    public static void banUser(UserBean user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.banUser(user);
            session.commit();
            session.close();
            System.out.println("禁用成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("禁用失败");
        }
    }
    public static void updateUser(UserBean user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.updateUser(user);
            session.commit();
            session.close();
            System.out.println("更新成功");
        }catch (Exception e){
            System.out.println("更新失败");
        }
    }

    public static void updateActivedUser(UserBean user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.updateActivedUser(user);
            session.commit();
            session.close();
            System.out.println("更新成功");
        }catch (Exception e){
            System.out.println("更新失败");
        }
    }

    public static List<UserBean> selectAllUsers(){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<UserBean> results = mapper.getAllUsers();

        session.commit();
        session.close();
        return results;
    }
    public static void main(String[] args){
//        UserBean user = new UserBean("12345","123","536523401@qq.com","123","123","2024-2-4","this is a url!");
//        UserDAO.insertUser(user);
//        boolean flag = UserDAO.checkAvailable(user);
//        UserDAO.selectAllUsers();
//        System.out.println(flag);
    }
}
