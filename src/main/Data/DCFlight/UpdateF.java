package DCFlight;

import DatabaseInfo.flights;
import DatabaseManage.Sql;

import java.sql.SQLException;

public class UpdateF {
    private String flightNum;
    private int price;
    private int numSeats;
    private int numAvail;
    private String FromCity;
    private String ArivCity;

    public UpdateF(String flightNum, int price, int numSeats, int numAvail, String fromCity, String arivCity) {
        this.flightNum = flightNum;
        this.price = price;
        this.numSeats = numSeats;
        this.numAvail = numAvail;
        FromCity = fromCity;
        ArivCity = arivCity;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public void setNumAvail(int numAvail) {
        this.numAvail = numAvail;
    }

    public String getFromCity() {
        return FromCity;
    }

    public void setFromCity(String fromCity) {
        FromCity = fromCity;
    }

    public String getArivCity() {
        return ArivCity;
    }

    public void setArivCity(String arivCity) {
        ArivCity = arivCity;
    }
    public void updateInfo() throws SQLException, ClassNotFoundException {//String str1,int str2,String str3,int str4,String str5,String str6
        Sql Sql = new Sql();
        Sql.updateflights(new flights(flightNum,price,numSeats,numAvail,FromCity,ArivCity));//传参
    }

}
