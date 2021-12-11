package domain;

public class Order {
    private  String oid;
    private int omoney;
    private  String o_uid;
    private  String o_pid;

    public String getOid() {
        return oid;
    }

    public int getOmoney() {
        return omoney;
    }

    public String getO_pid() {
        return o_pid;
    }

    public String getO_uid() {
        return o_uid;
    }

    public void setO_pid(String o_pid) {
        this.o_pid = o_pid;
    }

    public void setO_uid(String o_uid) {
        this.o_uid = o_uid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public void setOmoney(int omoney) {
        this.omoney = omoney;
    }
}
