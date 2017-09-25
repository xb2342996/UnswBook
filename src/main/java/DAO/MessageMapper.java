package DAO;

import Models.MessageBean;

import java.util.List;

public interface MessageMapper {
    public void insertMessage(MessageBean message);
    public List<MessageBean> getAllMessages(String username);
    public List<MessageBean> getUserMessages(String username);
}
