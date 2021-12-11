package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test {
    public static void main(String[] args) throws SQLException {
        // 注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 获得链接
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlineshop", "root", "1234");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://120.25.87.166:3306/onlineshop", "root", "e9fcc054c27860d0");
        Connection conn = DriverManager.getConnection("jdbc:mysql://120.25.154.59:3306/homework", "homework", "123456");
        // 得到操作数据库sql语句的对象Statement
        Statement st = conn.createStatement();
        // 执行
        ResultSet resultSet = st.executeQuery("SELECT * from users;");
        System.out.println(resultSet);
        while (resultSet.next()){
            System.out.println(resultSet.getString("uid"));
        }
        // 获得结果 集合

        // 关闭资源
//        rs.close();
        st.close();
        conn.close();
    }
}