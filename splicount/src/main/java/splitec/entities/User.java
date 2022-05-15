package splitec.entities;

import org.bson.types.ObjectId;

public class User {
    private ObjectId id;
    private String name;
    private String password;

    User(String name, String password, ObjectId id) {
        this.name = name;
        this.password = password;
        this.id = id;
    }

    User() {
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public ObjectId getId() {
        return this.id;
    }
}
