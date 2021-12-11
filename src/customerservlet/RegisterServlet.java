package customerservlet;

import dao.UserDao;
import org.apache.commons.lang3.RandomStringUtils;
import utils.JDBCUtils;
import domain.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

import utils.MailUtils;
//注册模块
@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static UserDao dao = new UserDao();
    private static final long serialVersionUID = 1L;


    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
                 String method = request.getParameter("method");
                if ("add".equals(method)) {
                    try {
                        add(request, response);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
    }


    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        User user = new User();
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String useremail = request.getParameter("useremail");
        user.setUid(RandomStringUtils.randomNumeric(10));
        user.setUsername(username);
        user.setUserpassword(userpassword);
        user.setUseremail(useremail);
        user.setUrole("normal");
                boolean b = dao.insert(user);
        MailUtils mail= new MailUtils(user.getUseremail());//把用户标识码UID发邮件

        if(b) {
                         request.setAttribute("message", "注册成功！");
                         request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else {
                         request.setAttribute("message", "已有账号，重复登录！");
                         request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }
}

