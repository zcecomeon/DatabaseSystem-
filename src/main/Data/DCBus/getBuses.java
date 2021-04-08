package DCBus;

import DatabaseManage.DbUtil;
import DCGoddess.GoddessBuses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getBuses {
    public GoddessBuses read(String location){
        //SearchFrm searchFrm=null;
        GoddessBuses g=null;
        Connection conn = DbUtil.getCon();
        //sql, 每行加空格
        String sql = "select * from  buses where location=?";
        //预编译SQL，减少sql执行
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, location);
            ResultSet rs = ptmt.executeQuery();
            while(rs.next()){
                g=new GoddessBuses();
                g.setLocation(rs.getString("location"));
                g.setPrice(rs.getInt("price"));
                g.setNumBuses(rs.getInt("numBus"));
                g.setNumAvail(rs.getInt("numAvail"));
            }
        }catch (Exception e){
            System.out.println("getBuses异常");
        }
        //执行
        return g;
    }
}
