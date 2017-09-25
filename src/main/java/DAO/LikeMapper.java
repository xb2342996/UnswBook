package DAO;

public interface LikeMapper {
    public void like(String username, String messageId);
    public void unlike(String username, String messageId);
}
