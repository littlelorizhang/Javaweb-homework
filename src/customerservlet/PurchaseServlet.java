package customerservlet;

import dao.CartDao;
import dao.OrderDao;
import dao.ProductDao;
import dao.UserDao;
import domain.Order;
import utils.JDBCUtils;
import utils.MailUtils;
import org.apache.commons.lang3.RandomStringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    JDBCUtils db = new JDBCUtils();
    private static final long serialVersionUID = 1L;
    private static CartDao dao=new CartDao();
    private static OrderDao dao2=new OrderDao();
    private static UserDao dao3=new UserDao();
    private static ProductDao dao4=new ProductDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session=request.getSession();
        String uid=(String) session.getAttribute("uid");
        String pid=(String) session.getAttribute("pid");
        String cid=(String) session.getAttribute("cid");
        String ppid=request.getParameter("ppid");
        String ccid=request.getParameter("ccid");
        String uuid=request.getParameter("uuid");
        int cmoney=0;
        Order order=new Order();
        try {
            if(cid!=null&&uid!=null)
            {cmoney= dao.pruchase(uid,cid);
           }
//            else if(cid==null&&uid!=null){
//                cmoney= dao.pruchase(uid,ccid);
//            }
            else{

                cmoney= dao.pruchase(uuid,ccid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(cmoney==0){
            response.getWriter().write("购买数量太多");
            //request.getRequestDispatcher("/customer/cart.jsp").forward(request,response);
        }
        else{//向order插入信息
            order.setOid(RandomStringUtils.randomNumeric(10));
            order.setOmoney(cmoney);
            if(uid!=null)
            order.setO_uid(uid);
            else{
                order.setO_uid(uuid);
            }
            if(pid!=null)
            order.setO_pid(pid);
            else{
                order.setO_pid(ppid);
            }
            boolean b=false;
            try {
                b= dao2.insert(order);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(b){

                boolean bb=false;
                try {
                    if(cid!=null&&pid!=null)
                    {
                        dao4.minedit(cid,pid);
                        bb= dao.delete(cid);
                    }//已经购买的产品从购物车删除
                    else{
                        dao4.minedit(ccid,ppid);
                        bb= dao.delete(ccid);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if(bb) {
                    request.setAttribute("message", "购买成功！");
                    try {

                        if(uid!=null){
                        MailUtils mail= new MailUtils(dao3.findemail(uid));

                        }
                        else{
                            MailUtils mail= new MailUtils(dao3.findemail(uuid));
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    session.removeAttribute("cid");
                    response.sendRedirect("ShoppingheadServlet");
                    //request.getRequestDispatcher("/customer/shopping.jsp").forward(request, response);
                }
                else {
                    response.getWriter().write("不行1");
                }
            }
            else {
                response.getWriter().write("不行2");
            }
        }
    }
}
