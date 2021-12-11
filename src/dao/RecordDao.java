package dao;
import domain.Product;
import domain.Record;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.JDBCUtils;
public class RecordDao {
    //查询某一用户的浏览记录
    public List<Record> listAll(String uid) throws SQLException {

        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Record> list=new ArrayList<Record>();
        try{
            conn=JDBCUtils.getConnection();

            String sql = "select pname from records,product where r_uid=? and r_pid=pid";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,uid);
            rs=stmt.executeQuery();
            while (rs.next()){
                Record record=new Record();
                record.setR_pname(rs.getString("pname"));
                //System.out.println(record.getR_pname());
                list.add(record);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs,stmt,conn);
        }
        return null;
    }
    //插入浏览信息
    public Boolean insert(Record record)throws SQLException, ClassNotFoundException{
        String sql="insert into records values(?,?,?)";
        Connection conn=null;
        conn=JDBCUtils.getConnection();
        PreparedStatement stmt=null;
        boolean f = false;
        try{
            stmt= conn.prepareStatement(sql);
            stmt.setString(1, record.getRid());
            stmt.setString(2,record.getR_uid());
            stmt.setString(3, record.getR_pid());
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.release(stmt,conn);
        }
        return f;
    }
}
