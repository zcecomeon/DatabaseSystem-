package DCCustomer;

import DatabaseManage.DbUtil;
import DCGoddess.GoddessCustomers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getCustomers {
    public GoddessCustomers read(String custName) {
        //SearchFrm searchFrm=null;
        GoddessCustomers g = null;
        Connection conn = DbUtil.getCon();
        //sql, 每行加空格
        String sql = "select * from  customers where custName=?";
        //预编译SQL，减少sql执行
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            //传参
            //String fromcity=searchFrm.getFromcity();String arivcity=searchFrm.getArivcity();
            ptmt.setString(1, custName);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                g = new GoddessCustomers();
                g.setCastName(rs.getString("custName"));
                g.setCustID(rs.getString("custID"));
            }
        } catch (Exception e) {
            System.out.println("getCustomers异常");

        }
        //执行
        return g;
    }
}