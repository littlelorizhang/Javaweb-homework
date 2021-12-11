package managerservlet;

import dao.OrderDao;
import domain.Order;
import utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SpecificOrderServlet", value = "/SpecificOrderServlet")
public class SpecificOrderServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static OrderDao dao=new OrderDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //HttpSession session=request.getSession();
        String uid=request.getParameter("uid");
        String pid=request.getParameter("pid");
        //String ppid= (String)session.getAttribute("pid");
        //System.out.print(ppid);
        //System.out.print(pid);

        if(uid !=null && pid==null){
            List<Order> ps= null;
            try {
                ps = dao.listuserorder(uid);
                request.setAttribute("ps",ps);
                request.getRequestDispatcher("/admin/specificorder.jsp").forward(request,response);
                return;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else{
            List<Order> ps= null;
            try {
                ps = dao.listproductorder(pid);
                request.setAttribute("ps",ps);
                request.getRequestDispatcher("/admin/specificorder.jsp").forward(request,response);
                return;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
