package managerservlet;

import dao.ProductDao;
import utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "EditProductServlet", value = "/EditProductServlet")
public class EditProductServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static ProductDao dao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String pid=request.getParameter("productid");
        String pname=request.getParameter("productname");
        String pprice=request.getParameter("productprice");
        String pallnum=request.getParameter("productallnum");
        boolean b=false;
        try {
            b= dao.edit(pname,pprice,pallnum,pid);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(b) {
            request.setAttribute("message", "修改商品成功！");
            request.getRequestDispatcher("/admin/godworld.jsp").forward(request,response);
        }
        else {
            request.setAttribute("message", "修改失败");
            request.getRequestDispatcher("/admin/listproduct.jsp").forward(request,response);
        }
        doGet(request,response);
    }
}
