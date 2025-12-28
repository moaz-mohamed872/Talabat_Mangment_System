package Talabat;
import java.util.Scanner;

public abstract class User {
    private String userName ;
    private String passWord;
    private boolean logedIn;


    public User(String userName, String passWord, boolean logedIn){
        setUserName(userName);
        setPassWord(passWord);
        setLogedIn(logedIn);
    }

    public User(){
        this("","",false);
    }

    public User(User user){
        this(user.userName, user.passWord,user.logedIn);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isLogedIn() {
        return logedIn;
    }

    public void setLogedIn(boolean logedIn) {
        this.logedIn = logedIn;
    }

    public void login(){
        this.logedIn=true;
    }

    public void logout(){
        this.logedIn=false;
    }

}
