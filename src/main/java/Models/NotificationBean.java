package Models;

public class NotificationBean {
    public String uuid;
    public String fromUser;
    public String toUser;
    public String type;
    public String content;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public NotificationBean(String uuid, String from, String to, String type, String content ){
        super();
        this.uuid = uuid;
        this.fromUser = from;
        this.toUser = to;
        this.type = type;
        this.content = content;
    }
    public NotificationBean(){
        super();
    }
}
