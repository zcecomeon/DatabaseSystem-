package DCBus;

import DatabaseManage.Sql;

import java.sql.SQLException;

public class DeleteB {
    private String location;

    public DeleteB(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void deleteInfo()throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.deletebuses(location);

    }



}
