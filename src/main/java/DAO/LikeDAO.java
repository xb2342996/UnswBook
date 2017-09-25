package DAO;

import Services.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;

public class LikeDAO {
    public static void like(String username, String messageId){
        SqlSession session = MybaitsUtil.getSession().openSession();
        LikeMapper mapper = session.getMapper(LikeMapper.class);
        try {
            mapper.like(username, messageId);
            session.commit();
            session.close();
            System.out.println("👍成功");
        }catch (Exception e){
            System.out.println("👍失败");
            e.printStackTrace();
        }
    }
    public static void unlike(String username, String messageId){
        SqlSession session = MybaitsUtil.getSession().openSession();
        LikeMapper mapper = session.getMapper(LikeMapper.class);
        try {
            mapper.unlike(username, messageId);
            session.commit();
            session.close();
            System.out.println("取消👍成功");
        }catch (Exception e){
            System.out.println("取消👍失败");
            e.printStackTrace();
        }
    }
}
