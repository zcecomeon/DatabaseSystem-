package DCFlight;
import DatabaseInfo.flights;
import DatabaseManage.Sql;

import java.sql.SQLException;

public   class InsertF {
    private String str1;
    private int str2;
    private int str3;
    private int str4;
    private String str5;
    private String str6;

    public InsertF(String str1, int str2, int str3, int str4, String str5, String str6) {
        this.str1 = str1;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
        this.str5 = str5;
        this.str6 = str6;
    }

    public void insertInfo() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.insertflights(new flights(str1, str2, str3, str4, str5, str6));//传参
    }

}
