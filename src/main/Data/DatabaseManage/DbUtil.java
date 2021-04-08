package DatabaseManage;

import DatabaseInfo.flights;

import java.sql.*;

public class DbUtil {
    public static final String URL  ="jdbc:mysql://localhost:3306/flights?useSSL=false";
    public static final String USER  ="root";
    public static final String PASSWORD  ="";
    public static Connection con=null;
    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static Connection getCon(){
        return con;
    }
}
