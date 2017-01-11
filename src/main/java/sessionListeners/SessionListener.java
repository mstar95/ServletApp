package sessionListeners;

/**
 * Created by mstarosta on 05.01.17.
 */

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ArrayList;

public class SessionListener implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent event) {
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.print("Uzytkownik zostal wylogowany");
    }

}