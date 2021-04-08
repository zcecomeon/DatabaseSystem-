package DCHotel;

import DatabaseManage.DbUtil;
import DCGoddess.GoddessHotels;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getHotels {
    public GoddessHotels read(String location){
        //SearchFrm searchFrm=null;
        GoddessHotels g=null;
        Connection conn = DbUtil.getCon();
        //sql, 每行加空格
        String sql = "select * from  hotels where location=?";
        //预编译SQL，减少sql执行
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            //传参
            //String fromcity=searchFrm.getFromcity();String arivcity=searchFrm.getArivcity();
            ptmt.setString(1, location);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()){
                g=new GoddessHotels();
                g.setLocation(rs.getString("location"));
                g.setPrice(rs.getInt("price"));
                g.setNumRooms(rs.getInt("numRooms"));
                g.setNumAvail(rs.getInt("numAvail"));
            }
        }catch (Exception e){
            System.out.println("getHotel异常");

        }
        //执行
        return g;
    }
}