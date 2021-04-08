package DatabaseInfo;

public class reservations {
    private String custName;
    private String resvType;
    private String resvKey;
    private String city;

    public reservations(String custName, String resvType, String resvKey,String city) {
        this.custName = custName;
        this.resvType = resvType;
        this.resvKey = resvKey;
        this.city=city;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getResvType() {
        return resvType;
    }

    public void setResvType(String resvType) {
        this.resvType = resvType;
    }

    public String getResvKey() {
        return resvKey;
    }

    public void setResvKey(String resvKey) {
        this.resvKey = resvKey;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
