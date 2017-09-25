package DAO;

public interface FriendMapper {
    public boolean isFriend(String user, String friend);
    public void addFriend(String user, String friend);
    public void deleteFriend(String user, String friend);
}
