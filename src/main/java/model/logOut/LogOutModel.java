package model.logOut;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LogOutModel {

    private static LogOutModel logOutModel;

    public static LogOutModel getInstance(){
        if(logOutModel == null){
            return new LogOutModel();
        }
        return logOutModel;
    }
    public static String OutSession(HttpSession session,String user){

         if(session.getAttribute(user) != null){
             session.invalidate();
             return "OK";
         }
         return null;
    }
}
