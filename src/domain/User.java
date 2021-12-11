package domain;
//用户信息
public class User {
    private String uid;//标识符自动生成
    private String username;//用户名
    private String userpassword;//密码
    private String useremail;//邮箱
    private String urole;//身份默认是普通用户
    public String getUid(){
        return uid;
    }
    public void setUid(String uid){
        this.uid=uid;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUserpassword(){
        return userpassword;
    }
    public void setUserpassword(String userpassword){
        this.userpassword=userpassword;
    }
    public String getUseremail(){
        return useremail;
    }
    public void setUseremail(String useremail){
        this.useremail=useremail;
    }
    public String getUrole(){
        return urole;
    }
    public void setUrole(String urole){
        this.urole=urole;
    }

    @Override
    public String toString(){
        return "user[uid="+uid+",username="+username+",password="+
                userpassword+"useremail="+useremail+
                "urole="+urole+"]";
    }
}
