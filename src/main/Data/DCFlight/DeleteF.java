package DCFlight;

import DatabaseManage.Sql;

import java.sql.SQLException;

public class DeleteF {
    private String flightNum;

    public DeleteF(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public void deleteInfo()throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        //Sql.insertflights(new flights(str1, str2, str3, str4, str5, str6));
        Sql.deleteflights(flightNum);
    }
}
