package User;

public class doctor {
    private String name, password;

    public doctor(String name , String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
}
