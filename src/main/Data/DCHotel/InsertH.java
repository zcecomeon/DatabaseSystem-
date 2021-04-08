package DCHotel;

import DatabaseInfo.flights;
import DatabaseInfo.hotels;
import DatabaseManage.Sql;

import java.sql.SQLException;

public class InsertH {
    private String str1;
    private int str2;
    private int str3;
    private int str4;

    public InsertH(String str1, int str2, int str3, int str4) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;

    }

    public void insertInfo() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.inserthotels(new hotels(str1, str2, str3, str4));//传参

    }

}