package managerservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import domain.Product;
import dao.ProductDao;
import utils.JDBCUtils;
@WebServlet(name = "BuyProductServlet", value = "/BuyProductServlet")
public class BuyProductServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static ProductDao dao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            System.out.print("go1");
            List<Product> ps= dao.listAll();
            request.setAttribute("ps",ps);
            //response.sendRedirect("/customer/shopping.jsp");
            request.getRequestDispatcher("/customer/shopping.jsp").forward(request,response);
            return;


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            response.getWriter().write("NOOK");
            return;

        }
    }
}
