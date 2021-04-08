package DCBus;

import DatabaseInfo.bus;
import DatabaseInfo.hotels;
import DatabaseManage.Sql;

import java.sql.SQLException;

public class UpdateB {
    private String location;
    private int price;
    private int numBus;
    private int numAvail;

    public UpdateB(String location, int price, int numBus, int numAvail) {
        this.location = location;
        this.price = price;
        this.numBus = numBus;
        this.numAvail = numAvail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumBus() {
        return numBus;
    }

    public void setNumBus(int numBus) {
        this.numBus = numBus;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(int numAvail) {
        this.numAvail = numAvail;
    }

    public void updateInfo() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.updatebuses(new bus(location,price,numBus,numAvail));//传参
    }
}
