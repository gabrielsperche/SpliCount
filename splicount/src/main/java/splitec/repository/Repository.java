package splitec.repository;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author gabrielsperche
 */

public class Repository {

    //Consult user on mongo database
    public boolean validateLogin(String username, String password) {
        MongoClient client = new MongoClient("localhost", 27017);
        MongoDatabase db = client.getDatabase("SpliCountDB");
        MongoCollection<Document> collection = db.getCollection("User");
        return true;
    }

    //Creates a new user in User collection
    public boolean createNewUser(String username, String password) throws Exception {
        try {
            MongoClient client = new MongoClient("localhost", 27017);
            MongoDatabase db = client.getDatabase("SpliCountDB");
            MongoCollection<Document> collection = db.getCollection("User");
            Document doc = new Document("Nome", username)
                    .append("Senha", password);
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
