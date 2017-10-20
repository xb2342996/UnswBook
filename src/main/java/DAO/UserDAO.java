package DAO;

import Models.UserBean;
import Models.NodeBean;
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
    public static List<NodeBean> getUserInfo(){

        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<NodeBean> results = mapper.getUserInfo();
        for (NodeBean node:results) {
            node.setGroup("friends");
        }

        session.commit();
        session.close();
        return results;
    }
    public static List<UserBean> selectUserByUsername(String username){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        List<UserBean> results = mapper.selectUserByUsername(username);

        session.commit();
        session.close();
        return results;
    }

    public static List<UserBean> selectUsersByGender(String gender){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> results = mapper.selectUsersByGender(gender);

        session.commit();
        session.close();
        return results;
    }

    public static List<UserBean> selectUsersByBirth(String birth){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> results = mapper.selectUsersByBirth(birth);
        session.commit();
        session.close();
        return results;
    }
    public static List<UserBean> selectUsersByName(String name){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> results = mapper.selectUsersByName(name);
        session.commit();
        session.close();
        return results;
    }


    public static List<UserBean> selectUsersByBirthandGender(String birth,String gender){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> results = mapper.selectUsersByBirthandGender(birth,gender);
        session.commit();
        session.close();
        return results;
    }
    public static List<UserBean> selectUsersByNameandGender(String name,String gender){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> results = mapper.selectUsersByNameandGender(name,gender);
        session.commit();
        session.close();
        return results;
    }
    public static List<UserBean> selectUsersByNameandBirth(String name,String birth){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> results = mapper.selectUsersByNameandBirth(name,birth);
        session.commit();
        session.close();
        return results;
    }
    public static List<UserBean> selectUsersByNameandBirthandGender(String name,String birth, String gender){
        SqlSession session = MybaitsUtil.getSession().openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<UserBean> results = mapper.selectUsersByNameandBirthandGender(name,birth,gender);
        session.commit();
        session.close();
        return results;
    }

    public static void main(String[] args){

    }
}
