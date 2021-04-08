package DCFlight;


import DatabaseManage.DbUtil;
import DCGoddess.GoddessFlights;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getFlights {
    public GoddessFlights read(String fromcity, String arivcity){
        //SearchFrm searchFrm=null;
        GoddessFlights g=null;
        Connection conn = DbUtil.getCon();
        //sql, 每行加空格
        String sql = "select * from  Flights where FromCity=? and ArivCity=?";
        //预编译SQL，减少sql执行
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            //传参
            //String fromcity=searchFrm.getFromcity();String arivcity=searchFrm.getArivcity();
            ptmt.setString(1, fromcity);ptmt.setString(2, arivcity);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()){
                g=new GoddessFlights();
                g.setFlightNum(rs.getString("flightNum"));
                g.setPrice(rs.getInt("price"));
                g.setNumSeats(rs.getInt("numSeats"));
                g.setNumAvail(rs.getInt("numAvail"));
                g.setFromCity(rs.getString("FromCity"));
                g.setArivCity(rs.getString("ArivCity"));
            }
        }catch (Exception e){

        }
        //执行
        return g;
    }
}
