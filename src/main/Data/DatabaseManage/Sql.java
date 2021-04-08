/*
* 读取数据参考博客链接：https://blog.csdn.net/yga_airspace/article/details/80369747
* */
package DatabaseManage;

import DatabaseInfo.*;


import java.sql.*;

public class Sql {
    static Statement statement;      //声明Statement对象
    static ResultSet resultSet;
    private Connection con=null;
    String[] Results=new String[6];
    public Sql() throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("数据库驱动加载成功");
        this.con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/flights?useSSL=false","root","");
        System.out.println("数据库连接成功");
    }
    public void close() throws SQLException {
        this.con.close();
    }

    public Connection getCon() {
        return con;
    }

    /*
* FLIGHTS (String flightNum, int price, int numSeats, int numAvail（可被预定座位数）, String FromCity, String ArivCity)；*/

/*
下面实现增删改查
 */
    public void insertflights(flights flights) throws SQLException{
        String sql="insert into Flights(flightNum,price,numSeats,numAvail,FromCity,ArivCity) values(?,?,?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,flights.getFlightNum());
        ps.setInt(2,flights.getPrice());
        ps.setInt(3,flights.getNumSeats());
        ps.setInt(4,flights.getNumAvail());
        ps.setString(5,flights.getFromCity());
        ps.setString(6,flights.getArivCity());
        ps.executeUpdate();
        ps.close();
    }

    public void deleteflights(String string) throws SQLException{
        String sql="delete from Flights where flightNum=?";
        PreparedStatement ps=con.prepareStatement(sql);//预编译
        ps.setString(1,string);
        ps.executeUpdate();
        ps.close();
    }
    public void updateflights(flights flights) throws SQLException{
        String sql="UPDATE Flights SET price=?,numSeats=?,numAvail=?,FromCity=?,ArivCity=? where FlightNum=?";//这里的修改语句在制作界面之后根据界面内容修改
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(6,flights.getFlightNum());
        ps.setInt(1,flights.getPrice());
        ps.setInt(2,flights.getNumSeats());
        ps.setInt(3,flights.getNumAvail());
        ps.setString(4,flights.getFromCity());
        ps.setString(5,flights.getArivCity());
        ps.executeUpdate();//执行更新语句
        ps.close();
    }


    public void inserthotels(hotels hotels) throws SQLException{
        String sql="INSERT into hotels(location,price,numRooms,numAvail) VALUES(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,hotels.getLocation());
        ps.setInt(2,hotels.getPrice());
        ps.setInt(3,hotels.getNumRooms());
        ps.setInt(4,hotels.getNumAvail());
        ps.executeUpdate();
        ps.close();
    }

    public void deletehotels(String string) throws SQLException{
        String sql="delete from hotels where location=?";
        PreparedStatement ps=con.prepareStatement(sql);//预编译
        ps.setString(1,string);
        ps.executeUpdate();
        ps.close();
    }
    public void updatehotels(hotels hotels) throws SQLException{
        String sql="UPDATE hotels SET price=?,numRooms=?,numAvail=? where location=?";//这里的修改语句在制作界面之后根据界面内容修改
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,hotels.getPrice());
        ps.setInt(2,hotels.getNumRooms());
        ps.setInt(3,hotels.getNumAvail());
        ps.setString(4,hotels.getLocation());
        ps.executeUpdate();//执行更新语句
        ps.close();
    }

    public void insertbuses(bus bus) throws SQLException{
        String sql="insert into buses(location,price,numBus,numAvail) values(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,bus.getLocation());
        ps.setInt(2,bus.getPrice());
        ps.setInt(3,bus.getNumBus());
        ps.setInt(4,bus.getNumAvail());
        ps.executeUpdate();
        ps.close();
    }

    public void deletebuses(String string) throws SQLException{
        String sql="delete from buses where location=?";
        PreparedStatement ps=con.prepareStatement(sql);//预编译
        ps.setString(1,string);
        ps.executeUpdate();
        ps.close();
    }
    public void updatebuses(bus bus) throws SQLException{
        String sql="UPDATE buses SET price=?,numBus=?,numAvail=? where location=?";//这里的修改语句在制作界面之后根据界面内容修改
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,bus.getPrice());
        ps.setInt(2,bus.getNumBus());
        ps.setInt(3,bus.getNumAvail());
        ps.setString(4,bus.getLocation());
        ps.executeUpdate();//执行更新语句
        ps.close();
    }
    public void insertcustomers(customers customers) throws SQLException{
        String sql="insert into customers(custName,custID) values(?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,customers.getCustName());
        ps.setString(2,customers.getCustID());
        ps.executeUpdate();
        ps.close();
    }
    public void deletecustomers(String string) throws SQLException{
        String sql="delete from customers where custName=?;";
        PreparedStatement ps=con.prepareStatement(sql);//预编译
        ps.setString(1,string);
        ps.executeUpdate();
        ps.close();
    }
    public void updatecustomers(customers customers) throws SQLException{
        String sql="UPDATE customers SET custID=? where custName=?";//这里的修改语句在制作界面之后根据界面内容修改
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(2,customers.getCustName());
        ps.setString(1,customers.getCustID());
        ps.executeUpdate();//执行更新语句
        ps.close();
    }

    public void insertreservations(reservations reservations) throws SQLException{
        String sql="insert into reservations(custName,resvType,resvKey,city) values(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,reservations.getCustName());
        ps.setString(2,reservations.getResvType());
        ps.setString(3,reservations.getResvKey());
        ps.setString(4,reservations.getCity());
        ps.executeUpdate();
        ps.close();
    }

    public void deletereservations(String string) throws SQLException{
        String sql="delete from reservations where resvKey=?";
        PreparedStatement ps=con.prepareStatement(sql);//预编译
        ps.setString(1,string);
        ps.executeUpdate();
        ps.close();
    }
    public void updatereservations(reservations reservations) throws SQLException{
        String sql="UPDATE reservations SET custName=?,resvType=? where resvKey=?";//这里的修改语句在制作界面之后根据界面内容修改
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,reservations.getCustName());
        ps.setString(2,reservations.getResvType());
        ps.setString(3,reservations.getResvKey());
        ps.executeUpdate();//执行更新语句
        ps.close();
    }



}
