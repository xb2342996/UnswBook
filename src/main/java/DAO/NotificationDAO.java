package DAO;

import Models.NotificationBean;
import Services.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NotificationDAO {
    public static void addNotification(NotificationBean noti){
        SqlSession session = MybaitsUtil.getSession().openSession();
        NotificationMapper mapper = session.getMapper(NotificationMapper.class);
        try {
            mapper.addNotification(noti);
            session.commit();
            session.close();
            System.out.println("插入成功");
        }catch (Exception e){
            System.out.println("插入失败");
            e.printStackTrace();
        }
    }
    public static List<NotificationBean> getNotificationByType(String to, String type){
        SqlSession session = MybaitsUtil.getSession().openSession();
        NotificationMapper mapper = session.getMapper(NotificationMapper.class);
        List<NotificationBean> noti = null;

        try {
            noti = mapper.getNotificationByType(to, type);
            session.commit();
            session.close();
        }catch (Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return noti;
    }
    public static void deleteNotification(NotificationBean noti){
        SqlSession session = MybaitsUtil.getSession().openSession();
        NotificationMapper mapper = session.getMapper(NotificationMapper.class);
        try {
            mapper.deleteNotification(noti.getUuid());
            session.commit();
            session.close();
            System.out.println("删除成功");
        }catch (Exception e){
            System.out.println("删除失败");
            e.printStackTrace();
        }
    }
}
