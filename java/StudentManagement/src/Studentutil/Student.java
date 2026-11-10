package Studentutil;

public class Student {
    private String username;
    private String password;
    private String password2;
    private String id;
    private String phonenumber;

    public Student() {}
    public Student(String username, String password, String id, String phonenumber) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.phonenumber = phonenumber;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPassword2(String password) {
        this.password2 = password;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;}
    public String getPassword2() {
        return password2;}
    public String getId() {
        return id;}

    public String getPhonenumber() {
        return phonenumber;}


}
