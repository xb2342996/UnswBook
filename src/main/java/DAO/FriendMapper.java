package DAO;

import Models.FriendBean;

import java.util.List;

public interface FriendMapper {
    public boolean isFriend(String user, String friend);
    public void addFriend(String user, String friend);
    public void deleteFriend(String user, String friend);
    public List<FriendBean> getFriends(String user);
}
