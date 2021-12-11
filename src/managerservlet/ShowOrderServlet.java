package managerservlet;

import dao.OrderDao;
import domain.Order;
import domain.Product;
import utils.JDBCUtils;

import javax.mail.Session;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowOrderServlet", value = "/ShowOrderServlet")
public class ShowOrderServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static OrderDao dao=new OrderDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession();
        String uid=request.getParameter("uid");
        String pid=request.getParameter("pid");
        try {
            if(uid==null && pid==null)
            {
                List<Order> ps= dao.listAll();
                request.setAttribute("ps",ps);
                request.getRequestDispatcher("/admin/showorder.jsp").forward(request,response);
                return;
            }
            else if(uid !=null && pid==null){
                List<Order> ps= dao.listuserorder(uid);
                request.setAttribute("ps",ps);
                request.getRequestDispatcher("/admin/specificorder.jsp").forward(request,response);
                return;
            }
            else{
                List<Order> ps= dao.listproductorder(pid);
                request.setAttribute("ps",ps);
                request.getRequestDispatcher("/admin/specificorder.jsp").forward(request,response);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("NOOK");
            return;
        }
    }
}
