package dao;
//包括新增用户（用户注册），用户查询（用户登录）
import java.sql.*;

import domain.User;

import utils.JDBCUtils;
public class UserDao {
    //新增用户
    public Boolean insert(User user) throws SQLException, ClassNotFoundException {
        String sql = "insert into users values('"+ user.getUid() + "','"+ user.getUsername() +"','"
               +user.getUserpassword()+"','"+user.getUseremail()+"','"
                +user.getUrole()+"')";
        Connection conn=JDBCUtils.getConnection();
        Statement state = null;
        boolean f = false;
        int a=0;
        try{
            state= conn.createStatement();
            a=state.executeUpdate(sql);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(state,conn);
        }
        if (a > 0){
            f=true;
        }
        return f;
    }
    //查找用户
    public  User search(String x,String y) throws SQLException, ClassNotFoundException{
        String sql="select * from users where uname= '"+x+"' and upassword= '"+y+"'";
        Connection conn=JDBCUtils.getConnection();
        Statement state = null;
        ResultSet rs=null;
        boolean f = false;

        try{
            state= conn.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next()){
                User user=new User();
                user.setUid(rs.getString("uid"));
                user.setUsername(rs.getString("uname"));
                user.setUserpassword(rs.getString("upassword"));
                user.setUseremail(rs.getString("uemail"));
                user.setUrole(rs.getString("urole"));
                return user;
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release( rs,state,conn);
        }

        return null;
    }
    //返回用户的email地址
    public String findemail(String uid) throws SQLException, ClassNotFoundException{
        Connection conn=JDBCUtils.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        String sql="select uemail from users where (uid=?)";
        stmt= conn.prepareStatement(sql);
        stmt.setString(1,uid);
        rs= stmt.executeQuery();
        while(rs.next()) {
            String emailadd = rs.getString("uemail");
            if (emailadd != null)
                return emailadd;
        }
        return null;
    }
}
