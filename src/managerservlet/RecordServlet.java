package managerservlet;

import dao.RecordDao;

import domain.Product;
import domain.Record;
import utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "RecordServlet", value = "/RecordServlet")
public class RecordServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static RecordDao dao=new RecordDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid=request.getParameter("uid");
        //System.out.println(uid);
        try{
            List<Record> ps= dao.listAll(uid);
            request.setAttribute("ps",ps);
            request.getRequestDispatcher("/admin/userrecord.jsp").forward(request,response);
            return;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            response.getWriter().write("NOOK");
            return;
        }
    }
}
