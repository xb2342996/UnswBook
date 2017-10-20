package Models;

import java.util.List;

public class GraphBean {
    public List<NodeBean> nodes;
    public List<EdgeBean> edges;

    public GraphBean(List<NodeBean> nodes, List<EdgeBean> edges){
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<NodeBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodeBean> nodes) {
        this.nodes = nodes;
    }

    public List<EdgeBean> getEdges() {
        return edges;
    }

    public void setEdges(List<EdgeBean> edges) {
        this.edges = edges;
    }
}
