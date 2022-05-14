package splitec.entities;

public class User {
    private String id;
    private String name;
    private String password;

    User(String name, String password){
        this.name = name;
        this.password = password;
    }

    User(){}

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public String getId(){
        return this.id;
    }
}
