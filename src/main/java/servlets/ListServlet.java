 /**
 * Created by mstarosta on 04.01.17.
 */

 package servlets;
import managers.ProductManager;
import managers.ProductMemoryManagerImpl;
import model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.io.IOException;

import java.util.List;


@WebServlet(value="/list")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static ProductManager productManager = new ProductMemoryManagerImpl();
    private static Integer counter = 0;
    private static Integer sessionCounter=0;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        counter++;

        HttpSession session = request.getSession(false);
        if(session.getAttribute("sessionCounter") == null)
        {
            sessionCounter++;
            session.setAttribute("sessionCounter",sessionCounter);
        }
        String path = "/WEB-INF/views/list.jsp";

        List<Product> products = productManager.getProductsList();

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
        request.setAttribute("products", products);
        request.setAttribute("counter", counter);
        request.setAttribute("SessionListener", sessionCounter);
        dispatcher.forward(request,response);
    }

}
