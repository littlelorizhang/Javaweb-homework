package domain;
//商品信息
public class Product {
    private String pid;//商品标识号
    private String pname;//商品名称
    private int pprice;//商品价格
    private int pallnum;//商品库存
    public String getPid(){
        return pid;
    }
    public void setPid(String pid){
        this.pid=pid;
    }
    public String getPname(){
        return pname;
    }
    public void setPname(String pname){
        this.pname=pname;
    }
    public int getPprice(){
        return pprice;
    }
    public void setPprice(int pprice){
        this.pprice=pprice;
    }
    public int getPallnum(){
        return pallnum;
    }
    public void setPallnum(int pallnum){
        this.pallnum=pallnum;
    }
}
