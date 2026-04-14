package User;

public class patient {
    private String mobileno, name, password;
    public patient(){
        
    }
    public patient(String name , String password, String mobileno){
        this.name = name;
        this.password = password;
        this.mobileno = mobileno;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getMobileNo(){
        return mobileno;
    }
}
