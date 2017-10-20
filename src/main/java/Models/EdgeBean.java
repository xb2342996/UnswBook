package Models;

public class EdgeBean {
    public String from;
    public String to;
    public String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
    public EdgeBean(){
        super();
    }
    public EdgeBean(String from, String to ){
        super();
        this.from = from;
        this.to = to;
    }
}
