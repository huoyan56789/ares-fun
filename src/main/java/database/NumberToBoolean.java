package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ares
 * @date 2018/5/28 17:02
 */
public class NumberToBoolean
{
    public static void main(String[] args)
    {
        String sql = "select * from student";
        try
        {
            PreparedStatement ps = new MysqlDB().getPs(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getBoolean(1));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
