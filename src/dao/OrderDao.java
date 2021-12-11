package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.Product;
import domain.User;
import domain.Cart;
import utils.JDBCUtils;
import domain.Order;
public class OrderDao {
    //增加订单
    public Boolean insert(Order order) throws SQLException, ClassNotFoundException {
        String sql = "insert into orders values(?,?,?,?)";
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;


        boolean f = false;


        try{
            state= conn.prepareStatement(sql);
            state.setString(1, order.getOid());
            state.setInt(2,order.getOmoney());
            state.setString(3, order.getO_uid());
            state.setString(4, order.getO_pid());
            state.execute();
            return true;


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }

        return f;
    }
    //展示全部订单
    public List<Order> listAll() throws SQLException{
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Order> list=new ArrayList<Order>();
        try{
            conn=JDBCUtils.getConnection();
            stmt=conn.createStatement();
            String sql = "select * from orders";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Order order=new Order();
                order.setOid(rs.getString("oid"));
                order.setOmoney(rs.getInt("omoney"));
                order.setO_uid(rs.getString("o_uid"));
                order.setO_pid(rs.getString("o_pid"));
                list.add(order);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }
    //查询某一用户的订单
    public List<Order> listuserorder( String uid) throws SQLException{
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Order> list=new ArrayList<Order>();
        try{
            conn=JDBCUtils.getConnection();
            stmt=conn.createStatement();
            String sql = "select * from orders where o_uid= '"+uid+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Order order=new Order();
                order.setOid(rs.getString("oid"));
                order.setOmoney(rs.getInt("omoney"));
                order.setO_uid(rs.getString("o_uid"));
                order.setO_pid(rs.getString("o_pid"));
                list.add(order);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }
    //查询某一商品的订单
    public List<Order> listproductorder( String pid) throws SQLException{
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Order> list=new ArrayList<Order>();
        try{
            conn=JDBCUtils.getConnection();
            stmt=conn.createStatement();
            String sql = "select * from orders where o_pid= '"+pid+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Order order=new Order();
                order.setOid(rs.getString("oid"));
                order.setOmoney(rs.getInt("omoney"));
                order.setO_uid(rs.getString("o_uid"));
                order.setO_pid(rs.getString("o_pid"));
                list.add(order);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }
}
