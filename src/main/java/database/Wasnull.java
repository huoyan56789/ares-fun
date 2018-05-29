package database;


import json.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Ares
 * @date 2018/5/28 10:42
 */
public class Wasnull
{
    //在最新驱动中jdbc连接的url后面必须加上serverTimezone，否则time zone不一致，mysql服务器的时间和驱动的时间不一致，可选值有GMT(gmt+8时区，需要写成GMT%2B8)
    private static final String url = "jdbc:mysql://127.0.0.1/sims?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
    //新的驱动程序类是`com.mysql.cj.jdbc.Driver'。驱动程序通过SPI自动注册，通常不需要手动加载驱动程序类。
    //private static final String name = "com.mysql.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "123456";

    public static void main(String[] args)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            //Class.forName(name);
            conn = DriverManager.getConnection(url, username, password);
            String sql = "select * from student";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Student student =new Student();
            while(rs.next()){
                student.setName(rs.getString(3));
                student.setSex(rs.getString(4));
                student.setAge(rs.getInt(5));
                student.setCompany(rs.getString(6));
                if(rs.wasNull()){
                    student.setCompany("tydic");
                }
                System.out.println(student);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
