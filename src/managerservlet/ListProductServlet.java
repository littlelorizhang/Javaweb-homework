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
@WebServlet(name = "ListProductServlet", value = "/ListProductServlet")
public class ListProductServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static ProductDao dao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            List<Product> ps= dao.listAll();
            request.setAttribute("ps",ps);
            request.getRequestDispatcher("/admin/listproduct.jsp").forward(request,response);
            return;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            response.getWriter().write("NOOK");
            return;
        }
    }
}
