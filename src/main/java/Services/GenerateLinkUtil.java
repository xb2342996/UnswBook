package Services;

import Models.UserBean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateLinkUtil {
    private static final String check_code = "checkCode";

    public static String generateActiveLink(UserBean user){
        return "http://localhost:8080/activeAccount?username="+user.getUsername()+"&"+check_code+"="+generateCheckCode(user);
    }

    public static String generateAddFriendLink(String username, String friendname) {
        return "http://localhost:8080/addFriend?action=addConfirm&username="+username+"&friendname="+friendname;
    }

    public static String generateCheckCode(UserBean user){
        String username = user.getUsername();
        String randomCode = user.getRandomCode();
        System.out.println(randomCode);
        return md5(username + ":" + randomCode);
    }

    public static boolean verifyCheckcode(UserBean user, String check_code){
        System.out.println(generateCheckCode(user)+"+"+check_code);
        return generateCheckCode(user).equals(check_code);
    }

    private static String md5(String string) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("md5");
            md.update(string.getBytes());
            byte[] md5Bytes = md.digest();
            return bytes2Hex(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String bytes2Hex(byte[] byteArray)
    {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++)
        {
            if(byteArray[i] >= 0 && byteArray[i] < 16)
            {
                strBuf.append("0");
            }
            strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));
        }
        return strBuf.toString();
    }
}
