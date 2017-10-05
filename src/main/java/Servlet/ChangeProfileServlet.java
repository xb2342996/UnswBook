package Servlet;

import DAO.UserDAO;
import Models.UserBean;
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
import java.util.Iterator;
import java.util.List;

public class ChangeProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserBean user = (UserBean) req.getSession().getAttribute("userInfo");

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
        String password = null;
        String email = null;
        String name = null;
        String birth = null;
        String gender = null;
        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) { // 如果是表单域 ，就是非文件上传元素

                String filename = item.getName(); // 文件的全路径，绝对路径名加文件名


                String type = getPicSuffix(filename);
                file = user.getUsername() + "-avatar." + type;
                String url = req.getSession().getServletContext().getRealPath("/");
                String path = url +"avatar/" +file;

                System.out.println(path);
                File saveFile = new File(path); // 定义一个file指向一个具体的文件

                try {
                    item.write(saveFile);// 把上传的内容写到一个文件中
                } catch (Exception e) {
                    /* e.printStackTrace(); */
                    System.out.println("文件为空");
                }
            } else {
                String value = item.getString("UTF-8");
                if (item.getFieldName().equals("email")) {
                    email = value;
                } else if (item.getFieldName().equals("password")) {
                    password = value;
                } else if (item.getFieldName().equals("name")) {
                    name = value;
                } else if (item.getFieldName().equals("birth")) {
                    birth = value;
                } else if (item.getFieldName().equals("gender")) {
                    gender = value;
                }

            }
        }
        if (!password.equals("") && password != null){
            user.setPassword(password);
        }
        if (!email.equals("") && email != null){
            user.setEmail(email);
        }
        if (!name.equals("") && name != null){
            user.setName(name);
        }
        if (!birth.equals("") && birth != null){
            user.setBirth(birth);
        }
        if (!gender.equals("") && gender != null){
            user.setGender(gender);
        }
        if (!file.equals("") && file != null){
            user.setPhoto(file);
        }

        UserDAO.updateActivedUser(user);

        req.getSession().setAttribute("userInfo", user);
        String message = "success";
        resp.getWriter().write(message);
//            req.getRequestDispatcher("profile.jsp").forward(req, resp);

    }
    public static String getPicSuffix(String img_path){
        if (img_path == null || img_path.indexOf(".") == -1){
            return ""; //如果图片地址为null或者地址中没有"."就返回""
        }
        return img_path.substring(img_path.lastIndexOf(".") + 1).
                trim().toLowerCase();
    }
}
