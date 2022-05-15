package splitec.repository.dbconnection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoClients;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

public final class DatabaseConnection {

    private static MongoClient _mongoClient;
    private static Datastore _db;

    public static Datastore getConnection() {
        if (_db == null)
            instanciateDBConnection();
        return _db;
    }

    public static void closeDatabase() {
        _mongoClient.close();
    }

    public static void instanciateDBConnection() {
        _mongoClient = new MongoClient("localhost", 27017);
        _db = Morphia.createDatastore(MongoClients.create(), "SplicountDB");
        _db.getMapper().mapPackage("splicount.splitec.entities");
        _db.ensureIndexes();
    }
}
