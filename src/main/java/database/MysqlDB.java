package database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * @author Ares
 * @date 2018/5/28 17:03
 */
public class MysqlDB
{
    //在最新驱动中jdbc连接的url后面必须加上serverTimezone，否则time zone不一致，mysql服务器的时间和驱动的时间不一致，可选值有GMT(gmt+8时区，需要写成GMT%2B8)
    private static final String url = "jdbc:mysql://127.0.0.1/sims?characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
    //新的驱动程序类是`com.mysql.cj.jdbc.Driver'。驱动程序通过SPI自动注册，通常不需要手动加载驱动程序类。
//    private static final String name = "com.mysql.jdbc.Driver";
//    private static final String username = "root";
//    private static final String password = "123456";

    private Connection conn = null;
    public PreparedStatement ps = null;


    public PreparedStatement getPs(String sql)
    {
//        Class.forName(name);
        try
        {
            InputStream inStream = MysqlDB.class.getClassLoader().getResourceAsStream("application.properties");
            Properties prop = new Properties();
            prop.load(inStream);
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return ps;
    }
}
