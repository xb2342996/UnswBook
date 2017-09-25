package Models;

public class MessageBean {
    public String uuid;
    public String message;
    public String username;
    public String date;
    public boolean liked;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public MessageBean(String uuid, String username, String message, String date){
        super();
        this.uuid = uuid;
        this.username = username;
        this.message = message;
        this.date = date;
    }
    public MessageBean(){
        super();
    }
}
