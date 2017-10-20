package DAO;

import Models.EdgeBean;
import Models.NodeBean;
import Services.MybaitsUtil;
import com.sun.javafx.geom.Edge;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
    public static List<EdgeBean> getNodeLikes(){
        SqlSession session = MybaitsUtil.getSession().openSession();
        LikeMapper mapper = session.getMapper(LikeMapper.class);
        List<EdgeBean> results = null;
        try {
            results = mapper.getNodeLikes();
            for (EdgeBean edge: results) {
                edge.label = "liked";
            }
            session.close();
            System.out.println("查询成功");
        }catch (Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return results;
    }
    public static List<EdgeBean> getNodeLikeDetail(String content){
        SqlSession session = MybaitsUtil.getSession().openSession();
        LikeMapper mapper = session.getMapper(LikeMapper.class);
        List<EdgeBean> results = null;
        try {
            String format = "%" + content + "%";
            results = mapper.getNodeLikeDetail(format);
            for (EdgeBean edge: results) {
                edge.label = "liked";
            }
            session.close();
            System.out.println("查询成功");
        }catch (Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return results;
    }

    public static List<NodeBean> getNodeLiker(String content){
        SqlSession session = MybaitsUtil.getSession().openSession();
        LikeMapper mapper = session.getMapper(LikeMapper.class);
        List<NodeBean> results = null;
        try {
            String format = "%" + content + "%";
            results = mapper.getNodeLiker(format);
            session.close();
            System.out.println("查询成功");
        }catch (Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return results;
    }

}
