package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//注解的方式声明servlet的路径
@WebServlet("/UploadTestServlet")
public class UploadTestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /** 上传目录名*/
    private static final String UPLOAD_DIR = "uploadDir/img/";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } // 解析request请求
        String path = null;
        String email = null;
        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (!item.isFormField()) { // 如果是表单域 ，就是非文件上传元素

                String fieldName = item.getFieldName(); // 文件域中name属性的值
                String filename = item.getName(); // 文件的全路径，绝对路径名加文件名
                /*
                 * String contentType = item.getContentType(); // 文件的类型 long
                 * size = item.getSize(); // 文件的大小，以字节为单位
                 */
                String dir = System.getProperty("user.dir").substring(0, System.getProperty("user.dir").length() - 4);

                path = dir + "/webapps/img/" + filename;
                File saveFile = new File(path); // 定义一个file指向一个具体的文件

                try {
                    item.write(saveFile);// 把上传的内容写到一个文件中
                } catch (Exception e) {
                    /* e.printStackTrace(); */
                    System.out.println("文件为空");
                }
            }else {
                String value = item.getString("UTF-8");
                if (item.getFieldName().equals("gender")){
                    email = value;
                }
            }
        }
        System.out.println(path);
        System.out.println(email);
    }
}