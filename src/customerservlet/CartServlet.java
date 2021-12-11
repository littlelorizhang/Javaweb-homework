package customerservlet;

import dao.CartDao;
import domain.Cart;
import utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static CartDao dao=new CartDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String uid=(String) session.getAttribute("uid");
        String pid=(String) session.getAttribute("pid");
        String cid=(String) session.getAttribute("cid");


        String uuid=request.getParameter("uid");//单单点击购物车时用这个传uid

        try{
            if(uid!=null)
            {
                List<Cart> ps= dao.listAll(uid);
                //System.out.print("go1");
                request.setAttribute("ps",ps);
                request.setAttribute("uid",uid);
                request.setAttribute("pid",pid);
                request.setAttribute("cid",cid);
                //System.out.print("go2");
                request.getRequestDispatcher("/customer/cart.jsp").forward(request,response);
                //System.out.print("go3");
            return;
            }
            else{
                List<Cart> ps= dao.listAll(uuid);
                //System.out.print("go1");
                request.setAttribute("ps",ps);
                request.setAttribute("uid",uuid);
                request.setAttribute("pid",pid);
                request.setAttribute("cid",cid);
                //System.out.print("go2");
                request.getRequestDispatcher("/customer/cart.jsp").forward(request,response);
                //System.out.print("go3");
                return;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            response.getWriter().write("NOOK");
            return;
        }
    }
}
