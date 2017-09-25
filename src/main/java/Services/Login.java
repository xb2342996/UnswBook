package Services;

import Models.UserBean;


public class Login {
    public static void main(String args[]){

    }

    public boolean passwordCheck(UserBean user, String password){
        if (user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public boolean activeCheck(UserBean user){
        if (user.isActived()){
            return true;
        }
        return false;
    }

}
