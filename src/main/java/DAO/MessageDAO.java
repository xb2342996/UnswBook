package DAO;

import Models.MessageBean;
import Services.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;

import javax.mail.MessageAware;
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
            System.out.println("查询失败");
        }
        return result;
    }
}
