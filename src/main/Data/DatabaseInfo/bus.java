package DatabaseInfo;
/*
快速创建方法：alt+ins
 */
public class bus {
    private String location;
    private int price;
    private int numBus;
    private int numAvail;

    public bus(String location, int price, int numBus, int numAvail) {
        this.location = location;
        this.price = price;
        this.numBus = numBus;
        this.numAvail = numAvail;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public int getNumBus() {
        return numBus;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setNumBus(int numBus) {
        this.numBus = numBus;
    }

    public void setNumAvail(int numAvail) {
        this.numAvail = numAvail;
    }
}
