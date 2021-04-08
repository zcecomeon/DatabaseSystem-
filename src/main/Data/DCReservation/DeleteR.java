package DCReservation;

import DatabaseManage.Sql;

import java.sql.SQLException;

public class DeleteR {

    private String resvKey;

    public DeleteR(String resvKey) {
        this.resvKey = resvKey;
    }

    public String getResvKey() {
        return resvKey;
    }

    public void setResvKey(String resvKey) {
        this.resvKey = resvKey;
    }

    public void deleteInfo()throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        //Sql.insertflights(new flights(str1, str2, str3, str4, str5, str6));
        Sql.deletereservations(resvKey);
    }

}
