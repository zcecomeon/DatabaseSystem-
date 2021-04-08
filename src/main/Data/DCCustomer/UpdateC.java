package DCCustomer;

import DatabaseInfo.customers;
import DatabaseManage.Sql;

import java.sql.SQLException;

public class UpdateC {
    private String custName;
    private String custID;

    public UpdateC(String custName, String custID) {
        this.custName = custName;
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }
    public void updateInfo() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.updatecustomers(new customers(custName,custID));//传参
    }
}
