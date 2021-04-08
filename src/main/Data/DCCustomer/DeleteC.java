package DCCustomer;

import DatabaseManage.Sql;

import java.sql.SQLException;

public class DeleteC {
    private String custNane;

    public String getCustNane() {
        return custNane;
    }
    public void setCustNane(String custNane) {
        this.custNane = custNane;
    }
    public DeleteC(String custNane) {
        this.custNane = custNane;
    }
    public void deleteInfo() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.deletecustomers(custNane);
       // System.out.println("删除成功");
    }
}