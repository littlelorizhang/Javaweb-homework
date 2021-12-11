package customerservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.ProductDao;
import domain.Product;
import domain.User;
import utils.JDBCUtils;

//用户成功登陆后在页面显示出用户已登录
@WebServlet(name = "ShoppingheadServlet", value = "/ShoppingheadServlet")
public class ShoppingheadServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static ProductDao dao=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //创建或保存用户信息的session
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        request.setAttribute("username",user.getUsername());//方便在shopping头部显示已登录的信息
        request.setAttribute("logout","<a href='LogoutServlet'>退出</a");
        request.setAttribute("uid",user.getUid());
        request.setAttribute("user",user);
        //response.getWriter().print("<a href='/LogoutServlet'>退出</a");
        //创建Cookie 存放session标识号
        Cookie cookie=new Cookie("JSESSIONID",session.getId());
        cookie.setMaxAge(60*30);
        cookie.setPath("");
        response.addCookie(cookie);


        if(user.getUrole().equals("normal")) {

            try{

                List<Product> ps= dao.listAll();
                request.setAttribute("ps",ps);
                //response.sendRedirect("/customer/shopping.jsp");
                request.getRequestDispatcher("/customer/shopping.jsp").forward(request,response);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                response.getWriter().write("NOOK");


            }
            //response.sendRedirect("/BuyProductServlet");
            //RequestDispatcher dispatcher=request.getRequestDispatcher("/customer/shopping.jsp");
            //dispatcher.forward(request,response);

        }
        else{
            RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/godworld.jsp");
            dispatcher.forward(request,response);

        }
    }
}
