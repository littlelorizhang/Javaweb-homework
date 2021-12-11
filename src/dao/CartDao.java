package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.Product;
import domain.User;
import domain.Cart;
import utils.JDBCUtils;
import java.io.IOException;
public class CartDao {
    //往数据库添加购物车信息
    public Boolean insert(Cart cart) throws SQLException, ClassNotFoundException {
        String sql = "insert into cart values(?,?,?,?)";
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;


        boolean f = false;

        try{
            state= conn.prepareStatement(sql);
            state.setString(1, cart.getCid());
            state.setInt(2,cart.getCnum());
            state.setString(3, cart.getC_uid());
            state.setString(4, cart.getC_pid());
            state.execute();
            return true;


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }

        return f;
    }
    //根据用户id展示购物车
    public List<Cart> listAll(String uid) throws SQLException {

        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Cart> list=new ArrayList<Cart>();
        try{
            conn=JDBCUtils.getConnection();

            String sql = "select pname,cnum,pprice,c_pid,cid from cart,product where  pid=c_pid and c_uid= '"+uid+"'";

            stmt=conn.prepareStatement(sql);
            //stmt.setString(1,uid);
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Cart cart=new Cart();
                cart.setCid(rs.getString("cid"));
                cart.setC_pname(rs.getString("pname"));
                //System.out.print(cart.getCid());
                cart.setCnum(rs.getInt("cnum"));
                //cart.setC_uid(rs.getString("c_uid"));
                cart.setC_pid(rs.getString("c_pid"));
                cart.setC_pprice(rs.getInt("pprice"));
                list.add(cart);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }
    //判断库存是否足够
    public int pruchase(String uid,String cid)throws SQLException, ClassNotFoundException{
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;
        PreparedStatement state2 = null;
        ResultSet rs=null;

        //比对pallnum和cnum的关系,返回总价格cmoney
        String sql="select cnum,pallnum,pprice from cart,product where c_pid=pid and (c_uid= ? and cid= ?)";
        //
        boolean f = false;
        try{
            state= conn.prepareStatement(sql);
            state.setString(1, uid);
            state.setString(2, cid);
            rs=state.executeQuery();
            while (rs.next()) {
                int num1 = rs.getInt("cnum");
                int num2 = rs.getInt("pallnum");
                int num3 = rs.getInt("pprice");
                if (num1 <= num2) {
                    int sum = num1 * num3;
                    //System.out.print(sum);
                    return sum;
                } else {
                    return 0;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }

        return 0;
    }
    //删除购物车信息
    public Boolean delete(String cid)throws SQLException, ClassNotFoundException{
        String sql = "delete from cart where cid=?";
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;


        boolean f = false;

        try{
            state= conn.prepareStatement(sql);
            state.setString(1, cid);
            state.execute();
            return true;


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }

        return f;
    }
}
