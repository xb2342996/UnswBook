package Servlet;

import DAO.MessageDAO;
import DAO.ReportDAO;
import Models.Activity;
import Models.MessageBean;
import Models.UserBean;
import Services.DateUtil;
import Services.EmailUtil;
import Services.Extractor;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean user = (UserBean)req.getSession().getAttribute("userInfo");

        String username = user.getUsername();
        String uuid = UUID.randomUUID().toString();

        resp.setContentType("text/html");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } // 解析request请求
        String file = null;
        String messageString = null;
        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) { // 如果是表单域 ，就是非文件上传元素

                String filename = item.getName(); // 文件的全路径，绝对路径名加文件名
                if (!filename.equals("")){
                    String type = getPicSuffix(filename);
                    file = uuid + "." + type;

                    String url = req.getSession().getServletContext().getRealPath("/");
                    String path = url +"upload/" +file;
                    System.out.println(path);


                    File saveFile = new File(path); // 定义一个file指向一个具体的文件

                    try {
                        item.write(saveFile);// 把上传的内容写到一个文件中
                    } catch (Exception e) {
                        /* e.printStackTrace(); */
                        System.out.println("文件为空");
                    }
                }
            }else {
                String value = item.getString("UTF-8");
                if (item.getFieldName().equals("message")){
                    messageString = value;
                }
            }
        }
        //插入消息到数据库

        MessageBean message = new MessageBean(uuid, username, messageString, DateUtil.getCurrentTime(), file);
        MessageDAO.insertMessage(message);
        List<String> people = null;
        try {
            people = Extractor.highlightPeople(message);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String[] keyword = null;
        try {
            keyword = Extractor.highlightKeyword(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String operation = user.getUsername()+ " posted a message at UNSWBook Wall.";

        Activity activity = new Activity(UUID.randomUUID().toString(),user.getUsername(), DateUtil.getCurrentTime(),operation);
        activity.setKeyword(String.join(", ", keyword));
        activity.setName_entity(String.join(", ",people));
        ReportDAO.addActivity(activity);

        EmailUtil.sendNotification(message,String.join(", ", keyword),String.join(", ",people));
        //获取所有消息 返回主页
        List<MessageBean> results = MessageDAO.getAllMessages(username);
        resp.getWriter().write("Send Successfully");
        req.getSession().setAttribute("allMessages", results);

    }
    public static String getPicSuffix(String img_path){
        if (img_path == null || img_path.indexOf(".") == -1){
            return ""; //如果图片地址为null或者地址中没有"."就返回""
        }
        return img_path.substring(img_path.lastIndexOf(".") + 1).
                trim().toLowerCase();
    }
}
