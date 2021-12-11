package customerservlet;

import dao.ProductDao;
import domain.Product;
import domain.User;
import utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SelectNameServlet", value = "/SelectNameServlet")
public class SelectNameServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static ProductDao dao=new ProductDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String pname=request.getParameter("pname");
        //System.out.println(pname);
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        request.setAttribute("username",user.getUsername());//方便在shopping头部显示已登录的信息
        request.setAttribute("logout","<a href='/LogoutServlet'>退出</a");
        request.setAttribute("uid",user.getUid());
        try {
            List<Product> ps= dao.listAllname(pname);
            request.setAttribute("ps",ps);
            request.getRequestDispatcher("/customer/shopping.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("NOOK");
        }

    }
}
