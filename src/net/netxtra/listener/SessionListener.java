package net.netxtra.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
      
    public void sessionCreated(HttpSessionEvent event) {
      try {
        HttpSession session = event.getSession();
        ServletContext context = session.getServletContext();
        Exception abortException = (Exception)context.getAttribute("app.abort");
        if (abortException == null){
          UseBeanSessionData sd = createSessionData();
          session.setAttribute(SessionData.SESSION_DATA_KEY, sd);
        }
     }
      catch (Exception e) {
         e.printStackTrace();
      }
    }

    protected UseBeanSessionData createSessionData(){
      return new UseBeanSessionData();
    }
    
    public void sessionDestroyed(HttpSessionEvent event) {
      HttpSession session = event.getSession();
        session.removeAttribute(SessionData.SESSION_DATA_KEY);
    };
}
