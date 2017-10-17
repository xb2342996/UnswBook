package DAO;

import Models.Activity;

import java.util.List;

public interface ReportMapper {
    public void addActivity(Activity activity);
    public List<Activity> getActivityByUser(String user);
}
