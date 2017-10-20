package DAO;

import Models.EdgeBean;
import Models.NodeBean;

import java.util.List;

public interface LikeMapper {
    public void like(String username, String messageId);
    public void unlike(String username, String messageId);
    public List<EdgeBean> getNodeLikes();
    public List<EdgeBean> getNodeLikeDetail(String content);
    public List<NodeBean> getNodeLiker(String content);
}
