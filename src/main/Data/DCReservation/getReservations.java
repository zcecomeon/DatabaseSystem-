package DCReservation;

import DatabaseManage.DbUtil;
import DCGoddess.GoddessReservations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getReservations {
    public GoddessReservations read(String resvKey){
        //SearchFrm searchFrm=null;
        GoddessReservations g=null;
        Connection conn = DbUtil.getCon();
        //sql, 每行加空格
        String sql = "select * from reservations where resvKey=?";
        //预编译SQL，减少sql执行
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            //传参
            //String fromcity=searchFrm.getFromcity();String arivcity=searchFrm.getArivcity();
            ptmt.setString(1, resvKey);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()){
                g=new GoddessReservations();
                g.setCustName(rs.getString("custName"));
                g.setResvType(rs.getString("resvType"));
                g.setResvKey(rs.getString("resvKey"));
                g.setCity(rs.getString("city"));
            }
        }catch (Exception e){
            System.out.println("getReservations异常");
        }
        //执行
        return g;
    }
}