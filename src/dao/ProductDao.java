package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import domain.Product;
import utils.JDBCUtils;
public class ProductDao {
    //查询全部商品
    public List<Product> listAll() throws SQLException {

        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Product> list=new ArrayList<Product>();
        try{
            conn=JDBCUtils.getConnection();
            stmt=conn.createStatement();
            String sql = "select * from product";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Product product=new Product();
                product.setPid(rs.getString("pid"));
                product.setPname(rs.getString("pname"));
                product.setPprice(rs.getInt("pprice"));
                product.setPallnum(rs.getInt("pallnum"));
                list.add(product);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }
    //添加商品
    public Boolean insert(Product product) throws SQLException, ClassNotFoundException {
        String sql = "insert into product values(?,?,?,?)";
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;


        boolean f = false;

        try{
            state= conn.prepareStatement(sql);
            state.setString(1, product.getPid());
            state.setString(2, product.getPname());
            state.setInt(3,product.getPprice());
            state.setInt(4,product.getPallnum());
            state.execute();
            return true;


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }

        return f;
    }
    //删除商品
    public Boolean delete(String x) throws SQLException, ClassNotFoundException {
        String sql = "delete from product where pid=?";
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;


        boolean f = false;

        try{
            state= conn.prepareStatement(sql);
            state.setString(1, x);
            state.execute();
            return true;


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }

        return f;
    }
    //修改商品
    public Boolean edit( String x,String y,String z,String pid) throws SQLException, ClassNotFoundException {
        //x=pname,y=pprice,z=pallnum

        int pprice=Integer.parseInt(y);
        int pallnum=Integer.parseInt(z);
        String sql="update product set pname=? , pprice=? ,pallnum=? where (pid=?)";
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;
        boolean f = false;
        try{
            state= conn.prepareStatement(sql);
            state.setString(1, x);
            state.setInt(2,pprice);
            state.setInt(3,pallnum);
            state.setString(4,pid);
            state.execute();
            return true;


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }
        return f;
    }
    //购买后减少库存
    public void minedit( String cid,String pid) throws SQLException, ClassNotFoundException {

        String sql="select cnum,c_pid,pallnum from cart,product where (cid=? and pid=?)";//先查出购买了多少和原库存
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement state = null;
        ResultSet rs=null;
        ResultSet rs2=null;
        int num1=0;
        int num2=0;
        int num3=0;
        boolean f = false;
        try{
            //System.out.print("go1");
            state= conn.prepareStatement(sql);
            state.setString(1,cid);
            state.setString(2,pid);
            rs= state.executeQuery();
            while(rs.next())
            {

                num1=rs.getInt("cnum");
                num2=rs.getInt("pallnum");
                String pid1=rs.getString("c_pid");
            }
            num3=num2-num1;
            String sql2="update product set pallnum=? where pid=?";
            try{
                state= conn.prepareStatement(sql2);
                state.setInt(1,num3);
                state.setString(2,pid);
                state.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }


    }
    //通过名字查找商品
    public List<Product> listAllname(String pname) throws SQLException {

        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Product> list=new ArrayList<Product>();
        try{
            conn=JDBCUtils.getConnection();
            stmt=conn.createStatement();
            String sql = "select * from product where pname= '"+pname+"'";
            rs=stmt.executeQuery(sql);
            while (rs.next()){
                Product product=new Product();
                product.setPid(rs.getString("pid"));
                product.setPname(rs.getString("pname"));
                product.setPprice(rs.getInt("pprice"));
                product.setPallnum(rs.getInt("pallnum"));
                list.add(product);
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
