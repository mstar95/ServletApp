package servlets;

/**
 * Created by mstarosta on 04.01.17.
 */

import managers.ProductManager;
import managers.ProductMemoryManagerImpl;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value={"/new","/edit","/delete"})
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static ProductManager productManager = new ProductMemoryManagerImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path="";
        if ((request).getServletPath().equals("/new")){
            path = "/WEB-INF/views/new-product.jsp";
        }
        if ((request).getServletPath().equals("/edit")){
            path = "/WEB-INF/views/edit-product.jsp";
            Product product = productManager.getProductByPK(new Integer(request.getParameter("pk")));
            request.setAttribute("product", product);
        }
        if ((request).getServletPath().equals("/delete")){
            path = "list";
            Product product = productManager.getProductByPK(new Integer(request.getParameter("pk")));
            productManager.deleteProduct(product);
            response.sendRedirect(path);
            return;
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
        dispatcher.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path;
        if ((request).getServletPath().equals("/new")){
            path = "list";

            String name = request.getParameter("Name");
            BigDecimal price = new BigDecimal(request.getParameter("Price"));

            productManager.insertProduct(new Product(name,price));

            response.sendRedirect(path);
        }
        if ((request).getServletPath().equals("/edit")){
            path = "list";

            Integer PK = new Integer(request.getParameter("PK"));
            String name = request.getParameter("Name");
            BigDecimal price = new BigDecimal(request.getParameter("Price"));

            productManager.updateProduct(new Product(PK,name,price));

            response.sendRedirect(path);
        }
    }
}
