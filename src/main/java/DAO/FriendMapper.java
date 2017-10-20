package DAO;

import Models.FriendBean;
import Models.EdgeBean;
import Models.NodeBean;

import java.util.List;

public interface FriendMapper {
    public boolean isFriend(String user, String friend);
    public void addFriend(String user, String friend);
    public void deleteFriend(String user, String friend);
    public List<FriendBean> getFriends(String user);
    public List<EdgeBean> getFriendsInfo();
    public List<NodeBean> getFriendsDetail(String user);
    public List<EdgeBean> getFriendsEdge(String user);
}
