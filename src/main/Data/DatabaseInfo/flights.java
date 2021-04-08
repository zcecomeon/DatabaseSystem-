package DatabaseInfo;

public class flights {
    private String flightNum;
    private int price;
    private int numSeats;
    private int numAvail;
    private String FromCity;
    private String ArivCity;

    public flights(String flightNum, int price, int numSeats, int numAvail, String fromCity, String arivCity) {
        this.flightNum = flightNum;
        this.price = price;
        this.numSeats = numSeats;
        this.numAvail = numAvail;
        this.FromCity = fromCity;
        this.ArivCity = arivCity;
    }
    @Override
    public String toString() {
        return "flights{" +
                " flightNum=" + flightNum +
                ", price='" + price+ '\'' +
                ", numSeats=" + numSeats+
                ", numAvail=" +numAvail+
                ",FromCity="+FromCity+
                ",ArivCity="+ArivCity+
                "}\n";
    }

    public String getFlightNum() {
        return flightNum;
    }

    public int getPrice() {
        return price;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public String getFromCity() {
        return FromCity;
    }

    public String getArivCity() {
        return ArivCity;
    }
}
