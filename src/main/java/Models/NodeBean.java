package Models;

public class NodeBean {
    public String id;
    public String label;
    public String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public NodeBean(String id, String label){
        super();
        this.id = id;
        this.label = label;
    }
    public NodeBean(){
        super();
    }
}
