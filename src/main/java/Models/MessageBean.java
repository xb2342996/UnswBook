package Models;

public class MessageBean {
    public String uuid;
    public String message;
    public String username;
    public String date;
    public boolean liked;
    public String picture;
    public String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

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

    public MessageBean(String uuid, String username, String message, String date, String picture){
        super();
        this.uuid = uuid;
        this.username = username;
        this.message = message;
        this.date = date;
        this.picture = picture;
    }
    public MessageBean(){
        super();
    }
}
