package DatabaseInfo;

public class customers {
    private String custName;
    private String custID;

    public customers(String custName, String custID) {
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
}


