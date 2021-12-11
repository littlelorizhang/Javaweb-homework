package customerservlet;
//负责登陆模块
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import dao.UserDao;
import domain.User;
import utils.JDBCUtils;

import java.sql.SQLException;
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static UserDao dao = new UserDao();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

            doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        User a=new User();
        try {
             a=dao.search(username,userpassword);

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (a!=null) {
            request.setAttribute("message", "欢迎登陆！");
            request.getSession().setAttribute("user",a);
            response.sendRedirect("ShoppingheadServlet");
            //request.getRequestDispatcher("shopping.jsp").forward(request, response);
        }
        else {
            request.setAttribute("message", "出错了！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
