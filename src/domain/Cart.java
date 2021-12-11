package domain;

public class Cart {
    private  String cid;
    private int cnum;
    private  String c_uid;
    private  String c_pid;
    private String c_pname;
    private int c_pprice;
    public String getCid(){
        return cid;
    }
    public String getC_uid(){
        return c_uid;
    }
    public String getC_pid(){
        return c_pid;
    }
    public int getCnum(){
        return cnum;
    }
    public String getC_pname(){
        return c_pname;
    }//展示商品名称
    public int getC_pprice(){
        return c_pprice;
    }//展示商品价格
    public  void setCid(String cid) {
        this.cid = cid;
    }

    public  void setC_uid(String c_uid) {
        this.c_uid = c_uid;
    }

    public  void setC_pid(String c_pid) {
        this.c_pid = c_pid;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public void setC_pname(String c_pname) {
        this.c_pname = c_pname;
    }

    public void setC_pprice(int c_pprice) {
        this.c_pprice = c_pprice;
    }
}
