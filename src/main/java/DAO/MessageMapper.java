package DAO;

import Models.EdgeBean;
import Models.MessageBean;
import Models.NodeBean;

import java.util.List;

public interface MessageMapper {
    public void insertMessage(MessageBean message);
    public List<MessageBean> getAllMessages(String username);
    public List<MessageBean> getUserMessages(String username);
    public List<NodeBean> getNodeMessages();
    public List<EdgeBean> getEdgeMessages();
    public List<NodeBean> getNodeMessageDetail(String content);
    public List<EdgeBean> getEdgeMessageDetail(String content);
    public List<NodeBean> getNodeMessagePoster(String content);
}
