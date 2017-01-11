package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mstarosta on 05.01.17.
 */
@WebServlet(value ={"/login","/logout"})
public class LoginServlet extends HttpServlet {
    private static Integer userID = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((request).getServletPath().equals("/login")){
            String username = request.getParameter("Login");
            String password = request.getParameter("Haslo");
            if("user".equals(username) && "123456".equals(password))
            {
                request.getSession().setAttribute("userID", userID++);
                response.sendRedirect(request.getContextPath() + "/list");
                return;
            }
            request.setAttribute("message", "Niepoprawne dane");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

        if ((request).getServletPath().equals("/logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("userID");
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/list");
        }

    }
}