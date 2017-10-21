package Servlet;

import DAO.FriendDAO;
import DAO.LikeDAO;
import DAO.MessageDAO;
import DAO.UserDAO;
import Models.GraphBean;
import Models.NodeBean;
import Models.EdgeBean;
import Models.UserBean;
import com.alibaba.fastjson.JSON;
import com.sun.javafx.geom.Edge;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Node;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        UserBean account = (UserBean)req.getSession().getAttribute("userInfo");
        String graphJson = "";
        if (action != null){
            String option = req.getParameter("options");
            String keyword = req.getParameter("keyword");
            if (option.equals("person")){

                UserBean user = UserDAO.getUser(keyword);
                ArrayList<NodeBean> node = new ArrayList<NodeBean>();
                node.add(new NodeBean(user.getUsername(), user.getUsername()));
                node.add(new NodeBean(user.getGender(), user.getGender()));
                node.add(new NodeBean(user.getBirth(), user.getBirth()));
                node.add(new NodeBean(user.getName(), user.getName()));

                ArrayList<EdgeBean> edge = new ArrayList<EdgeBean>();
                edge.add((new EdgeBean(user.getUsername(), user.getGender())));
                edge.add((new EdgeBean(user.getUsername(), user.getBirth())));
                edge.add((new EdgeBean(user.getUsername(), user.getName())));

                GraphBean graph = new GraphBean(node,edge);
                graphJson = JSON.toJSONString(graph);

            }else if (option.equals("message")){

                List<NodeBean> nodes = MessageDAO.getNodeMessageDetail(keyword);
                List<NodeBean> poster_node = MessageDAO.getNodeMessagePoster(keyword);
                List<NodeBean> liker_node = LikeDAO.getNodeLiker(keyword);

                nodes.addAll(poster_node);
                nodes.addAll(liker_node);


                List<EdgeBean> edges = MessageDAO.getEdgeMessageDetail(keyword);
                List<EdgeBean> like_edge = LikeDAO.getNodeLikeDetail(keyword);

                edges.addAll(like_edge);

                GraphBean graph = new GraphBean(nodes, edges);
                graphJson = JSON.toJSONString(graph);

            }else if (option.equals("friend")){
                if (keyword.equals("") || keyword == null){
                    List<NodeBean> nodes = new ArrayList<NodeBean>();
                    List<NodeBean> friend_nodes = FriendDAO.getFriendsDetail(account.getUsername());
                    nodes.addAll(friend_nodes);
                    for (NodeBean node : friend_nodes) {
                        List<NodeBean> friends_nodes = FriendDAO.getFriendsDetail(node.id);
                        nodes.addAll(friends_nodes);
                    }

                    List<EdgeBean> edges = FriendDAO.getFriendsInfo();
                    List<EdgeBean> clean_edges = remove_dupliacte(edges);

                    GraphBean graph = new GraphBean(nodes, clean_edges);
                    graphJson = JSON.toJSONString(graph);
                }else {

                    List<NodeBean> nodes = new ArrayList<NodeBean>();
                    nodes.add(new NodeBean(keyword, keyword));
                    nodes.addAll(FriendDAO.getFriendsDetail(keyword));

                    List<EdgeBean> edges = FriendDAO.getFriendsEdge(keyword);

                    GraphBean graph = new GraphBean(nodes, edges);
                    graphJson = JSON.toJSONString(graph);
                }
            }
        }else {
            List<NodeBean> nodes = UserDAO.getUserInfo();
            List<NodeBean> message_nodes = MessageDAO.getNodeMessage();
            nodes.addAll(message_nodes);

            List<EdgeBean> edges = FriendDAO.getFriendsInfo();
            List<EdgeBean> message_edges = MessageDAO.getEdgeMessage();
            List<EdgeBean> like_edges = LikeDAO.getNodeLikes();
            edges.addAll(message_edges);
            edges.addAll(like_edges);
            List<EdgeBean> clean_edges = remove_dupliacte(edges);

            GraphBean graph = new GraphBean(nodes, clean_edges);
            graphJson = JSON.toJSONString(graph);

        }
        resp.getWriter().write(graphJson);
    }
    public List<EdgeBean> remove_dupliacte(List<EdgeBean> edges){
        List<EdgeBean> tmp = new ArrayList<EdgeBean>();
        for (EdgeBean edge : edges) {
            boolean flag = true;
            for (EdgeBean temp : tmp){
                if ((temp.from.equals(edge.to) && temp.to.equals(edge.from)) || (temp.from.equals(edge.from) && temp.to.equals(edge.to))){
                    flag = false;
                    break;
                }
            }
            if (flag == true){
                tmp.add(edge);
            }
        }
        return tmp;
    }
}
