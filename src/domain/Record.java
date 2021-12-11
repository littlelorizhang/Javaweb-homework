package domain;

public class Record {
    private String rid;
    private String r_uid;
    private String r_pid;
    private String r_pname;
    public String getRid() {
        return rid;
    }

    public String getR_uid() {
        return r_uid;
    }

    public String getR_pid() {
        return r_pid;
    }

    public String getR_pname() {
        return r_pname;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setR_uid(String r_uid) {
        this.r_uid = r_uid;
    }

    public void setR_pid(String r_pid) {
        this.r_pid = r_pid;
    }

    public void setR_pname(String r_pname) {
        this.r_pname = r_pname;
    }
}
