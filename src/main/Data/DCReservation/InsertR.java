package DCReservation;

import DatabaseInfo.reservations;
import DatabaseManage.Sql;

import java.sql.SQLException;

public class InsertR {
    private  String custName;
    private String resvType;
    private String resvKey;
    private String city;

    public InsertR(String custName, String resvType, String resvKey,String city) {
        this.custName = custName;
        this.resvType = resvType;
        this.resvKey = resvKey;
        this.city=city;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getResvType() {
        return resvType;
    }

    public void setResvType(String resvType) {
        this.resvType = resvType;
    }

    public String getResvKey() {
        return resvKey;
    }

    public void setResvKey(String resvKey) {
        this.resvKey = resvKey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void insertInfo() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.insertreservations(new reservations(custName,resvType,resvKey,city));//传参

    }
}
