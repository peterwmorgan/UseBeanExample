package net.netxtra.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionData {
    
    public static final String SESSION_DATA_KEY = "useBeanSessionData";
        
    public static SessionData getData(HttpServletRequest request){  
      HttpSession session = request.getSession(true);
      SessionData sd = (SessionData)session.getAttribute("useBeanSessionData");
      return sd;
    }
}
