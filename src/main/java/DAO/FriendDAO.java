package DAO;

import Models.MessageBean;
import Services.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FriendDAO {
    public static boolean isFriend(String user, String friend){
        SqlSession session = MybaitsUtil.getSession().openSession();
        FriendMapper mapper = session.getMapper(FriendMapper.class);
        boolean result = mapper.isFriend(user, friend);
        session.close();
        return result;
    }

    public static void addFriend(String user, String friend){
        SqlSession session = MybaitsUtil.getSession().openSession();
        FriendMapper mapper = session.getMapper(FriendMapper.class);
        try {
            mapper.addFriend(user, friend);
            mapper.addFriend(friend,user);
            session.commit();
            session.close();
            System.out.println("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("插入失败");
        }
    }
    public static void deleteFriend(String user, String friend){

    }
}
