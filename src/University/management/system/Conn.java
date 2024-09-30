package University.management.system;
import java.sql.*;
public class Conn
{
    Connection con;
    Statement st;
    Conn()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universe","root","root");
            st = con.createStatement();
        }catch(Exception e)
        {
          e.printStackTrace();
        }
    }
    public static void main(String args[])
    {
        new Conn();
    }
}
