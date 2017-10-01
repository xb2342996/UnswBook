package DAO;

import Models.NotificationBean;

import java.util.List;

public interface NotificationMapper {
    public void addNotification(NotificationBean noti);

    public void deleteNotification(String uuid);

    public List<NotificationBean> getNotificationByType(String toUser, String Type);
}
