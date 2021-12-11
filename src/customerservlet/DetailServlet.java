package customerservlet;

import domain.User;
import domain.Record;
import utils.JDBCUtils;
import  dao.CartDao;
import dao.RecordDao;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.lang3.RandomStringUtils;

@WebServlet(name = "DetailServlet", value = "/DetailServlet")
public class DetailServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static CartDao dao = new CartDao();
    private static RecordDao dao2=new RecordDao();
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        User user=(User) session.getAttribute("user");
        String pid=request.getParameter("pid");
        String pname=request.getParameter("pname");
        String pprice=request.getParameter("pprice");
        String pallnum=request.getParameter("pallnum");
        String rid=RandomStringUtils.randomNumeric(10);
        Record record=new Record();
        record.setR_uid(user.getUid());
        record.setR_pid(pid);
        record.setRid(rid);
        boolean b=false;
        try {
            b=dao2.insert(record);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(b)
        {
            try{
            request.setAttribute("username",user.getUsername());//方便在shopping头部显示已登录的信息
            request.setAttribute("uid",user.getUid());
            request.setAttribute("logout","<a href='/LogoutServlet'>退出</a");
            request.setAttribute("pid",pid);
            request.setAttribute("pname",pname);
            request.setAttribute("pprice",pprice);
            request.setAttribute("pallnum",pallnum);
            request.getRequestDispatcher("/customer/detail.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else {
            response.getWriter().write("buxing");
        }
    }
}
