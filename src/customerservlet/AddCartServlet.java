package customerservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.lang3.RandomStringUtils;
import domain.Cart;
import utils.JDBCUtils;

import dao.CartDao;
//插入到数据库里
@WebServlet(name = "AddCartServlet", value = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
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
        String cnum=request.getParameter("cnum");
        Cart cart=new Cart();
        boolean b=false;
        cart.setC_pid(pid);
        cart.setC_uid(uid);
        //System.out.print(uid);
        int cnum1=Integer.parseInt(cnum);
        cart.setCnum(cnum1);
        String cid=RandomStringUtils.randomNumeric(10);
        cart.setCid(cid);
        try {
            b = dao.insert(cart);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(b) {
            request.setAttribute("message", "添加购物车成功！");
            request.getSession().setAttribute("uid",uid);
            request.getSession().setAttribute("pid",pid);
            request.getSession().setAttribute("cid",cid);
            response.sendRedirect("ShoppingheadServlet");
            //request.getRequestDispatcher("/customer/shopping.jsp").forward(request,response);
        }
        else {
            request.setAttribute("message", "添加失败");
            request.getRequestDispatcher("/customer/detail.jsp").forward(request,response);
        }
    }
}
