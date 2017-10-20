package Services;

import Models.MessageBean;
import Models.UserBean;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class EmailUtil {
    private static final String From = "xiongbiao147@gmail.com";

    public static void sendAccountActiveEmail(UserBean user){

        Session session = getSession();
        MimeMessage message = new MimeMessage(session);

        try{
            message.setSubject("active account Email!");
            message.setSentDate(new Date());
            message.setFrom(new InternetAddress(From));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            message.setContent("<a href='" + GenerateLinkUtil.generateActiveLink(user)+"'>click to active your account</a>","text/html;charset=utf-8");
            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void sendAddFriendEmail(String userEmail, String friendEmail, String username, String friendname){
        Session session = getSession();
        MimeMessage message = new MimeMessage(session);
        try {
            message.setSubject("add friend Email!");
            message.setSentDate(new Date());
            message.setFrom(new InternetAddress(userEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(friendEmail));
            message.setContent("<a href='" + GenerateLinkUtil.generateAddFriendLink(username, friendname)+"'>Add Friend!</a>","text/html;charset=utf-8");
            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sendNotification(MessageBean messageBean, String keyword, String name_entity){

        String content = messageBean.getUsername() + " posted a message.<br> The content is \""+ messageBean.getMessage() +"\".<br>";
        if (!keyword.equals("") && keyword != null){
            content += "Keywords: "+ keyword +".<br>";
        }
        if (!name_entity.equals("") && name_entity != null){
            content += "Name_entities: "+ name_entity +".";
        }

        Session session = getSession();
        MimeMessage message = new MimeMessage(session);
        try {
            message.setSubject("Message Notification");
            message.setSentDate(new Date());
            message.setFrom(new InternetAddress(From));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(From));
            message.setContent(content,"text/html;charset=utf-8");
            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Session getSession(){
        Properties pro = new Properties();
        pro.setProperty("mail.transport.protocol", "smtp");
        pro.setProperty("mail.smtp.host", "smtp.gmail.com");
        pro.setProperty("mail.smtp.port", "587");
        pro.setProperty("mail.smtp.auth", "true");
        pro.setProperty("mail.smtp.starttls.enable", "true");
        pro.setProperty("mail.debug","true");
        // 开启debug调试
//        pro.setProperty("mail.debug", "true");
//        // 发送服务器需要身份验证
//        pro.setProperty("mail.smtp.auth", "true");
//        // 设置邮件服务器主机名
//        pro.setProperty("mail.host", "smtp.163.com");
//        // 发送邮件协议名称
//        pro.setProperty("mail.transport.protocol", "smtp");

        Session session = Session.getInstance(pro, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("xiongbiao147@gmail.com","xiongbiao11");
            }
        });
        return session;
    }

}
