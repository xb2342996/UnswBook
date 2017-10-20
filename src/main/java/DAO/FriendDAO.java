package DAO;

import Models.FriendBean;
import Models.EdgeBean;
import Models.NodeBean;
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
    public static List<FriendBean> getFriends(String user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        FriendMapper mapper = session.getMapper(FriendMapper.class);
        List<FriendBean> result = null;
        try{
            result = mapper.getFriends(user);
            session.commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }
    public static void deleteFriend(String user, String friend){

    }
    public static List<EdgeBean> getFriendsInfo(){
        SqlSession session = MybaitsUtil.getSession().openSession();
        FriendMapper mapper = session.getMapper(FriendMapper.class);
        List<EdgeBean> result = null;
        try{
            result = mapper.getFriendsInfo();
            for (EdgeBean edge: result) {
                edge.label = "friendOf";
            }
            session.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }

    public static List<NodeBean> getFriendsDetail(String user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        FriendMapper mapper = session.getMapper(FriendMapper.class);
        List<NodeBean> result = null;
        try{
            result = mapper.getFriendsDetail(user);
            session.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }
    public static List<EdgeBean> getFriendsEdge(String user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        FriendMapper mapper = session.getMapper(FriendMapper.class);
        List<EdgeBean> result = null;
        try{
            result = mapper.getFriendsEdge(user);
            for (EdgeBean edge: result) {
                edge.label = "friendOf";
            }
            session.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }
}
