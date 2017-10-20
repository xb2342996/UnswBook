package DAO;

import Models.EdgeBean;
import Models.MessageBean;
import Models.NodeBean;
import Services.MybaitsUtil;
import com.sun.javafx.geom.Edge;
import org.apache.ibatis.session.SqlSession;

import javax.mail.MessageAware;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    public static void insertMessage(MessageBean message){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        try {
            mapper.insertMessage(message);
            session.commit();
            System.out.println("插入成功");
        }catch (Exception e){
            System.out.println("插入失败");
        }
        session.close();
    }

    public static List<MessageBean> getAllMessages(String username){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<MessageBean> result = null;
        try {
            result = mapper.getAllMessages(username);
            session.close();
            System.out.println("查询成功");

        }catch (Exception e) {
            System.out.println("查询失败");
        }
        return result;
    }

    public static List<MessageBean> getUserMessage(String username){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<MessageBean> result = null;
        try {
            result = mapper.getUserMessages(username);
            session.close();
            System.out.println("查询成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }

    public static List<NodeBean> getNodeMessage(){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<NodeBean> result = null;
        try {
            result = mapper.getNodeMessages();
            for (NodeBean node:result) {
                node.setGroup("posts");
            }
            session.close();
            System.out.println("查询成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }

    public static List<NodeBean> getNodeMessageDetail(String content){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<NodeBean> result = null;
        try {
            String format = "%" + content + "%";
            result = mapper.getNodeMessageDetail(format);
            for (NodeBean node:result) {
                node.setGroup("posts");
            }
            session.close();
            System.out.println("查询成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }

    public static List<EdgeBean> getEdgeMessage(){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<EdgeBean> result = null;
        try {
            result = mapper.getEdgeMessages();
            for (EdgeBean edge: result) {
                edge.label = "posted";
            }
            session.close();
            System.out.println("查询成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }
    public static List<EdgeBean> getEdgeMessageDetail(String content){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<EdgeBean> result = null;
        try {
            String format = "%" + content + "%";
            result = mapper.getEdgeMessageDetail(format);
            for (EdgeBean edge: result) {
                edge.label = "posted";
            }
            session.close();
            System.out.println("查询成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }
    public static List<NodeBean> getNodeMessagePoster(String content){
        SqlSession session = MybaitsUtil.getSession().openSession();
        MessageMapper mapper = session.getMapper(MessageMapper.class);
        List<NodeBean> result = null;

        try {
            String format = "%" + content + "%";
            result = mapper.getNodeMessagePoster(format);

            session.close();
            System.out.println("查询成功");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败");
        }
        return result;
    }
}
