package DAO;

import Models.Activity;
import Services.MybaitsUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ReportDAO {
    public static void addActivity(Activity activity){
        SqlSession session = MybaitsUtil.getSession().openSession();
        ReportMapper mapper = session.getMapper(ReportMapper.class);
        try {
            mapper.addActivity(activity);
            session.commit();
            session.close();
            System.out.println("插入成功");
        }catch (Exception e){
            System.out.println("插入失败");
            e.printStackTrace();
        }
    }
    public static List<Activity> getActivityByUser(String user){
        SqlSession session = MybaitsUtil.getSession().openSession();
        ReportMapper mapper = session.getMapper(ReportMapper.class);
        List<Activity> activities = null;

        try {
            activities = mapper.getActivityByUser(user);
            System.out.println("查询成功");
            session.commit();
            session.close();
        }catch (Exception e){
            System.out.println("查询失败");
            e.printStackTrace();
        }
        return activities;
    }
}
