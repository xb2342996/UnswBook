package Models;

public class Activity {
    public String uuid;
    public String user;
    public String date;
    public String operation;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Activity(String uuid, String user, String date, String operation){
        super();
        this.uuid = uuid;
        this.user = user;
        this.date = date;
        this.operation = operation;
    }
    public Activity(){
        super();
    }
}
