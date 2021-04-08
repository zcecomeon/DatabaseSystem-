package DCHotel;

import DatabaseManage.Sql;

import java.sql.SQLException;

public class DeleteH {
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public DeleteH(String location) {
        this.location = location;
    }

    public void deleteInfo()throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        //Sql.insertflights(new flights(str1, str2, str3, str4, str5, str6));
        Sql.deletehotels(location);
    }
}