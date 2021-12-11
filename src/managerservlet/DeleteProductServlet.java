package managerservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


import dao.ProductDao;
import utils.JDBCUtils;

@WebServlet(name = "DeleteProductServlet", value = "/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static ProductDao dao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("productid");
        boolean b=false;
        try {
            b= dao.delete(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(b) {
            request.setAttribute("message", "删除商品成功！");
            request.getRequestDispatcher("/admin/godworld.jsp").forward(request,response);
        }
        else {
            request.setAttribute("message", "删除失败");
            request.getRequestDispatcher("/admin/listproduct.jsp").forward(request,response);
        }
        doGet(request,response);
    }
}
