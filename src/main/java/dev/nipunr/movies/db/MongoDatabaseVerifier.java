package dev.nipunr.movies.db;

import com.mongodb.client.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoDatabaseVerifier {
    private static final Logger log = LoggerFactory.getLogger(MongoDatabaseVerifier.class);

    public MongoDatabaseVerifier(MongoClient mongoClient) {
        checkConnectionOrThrow(mongoClient);
    }

    /**
     * Calls {@link MongoClient#getAddress()} and throws the result away if successful
     * @param client
     */
    void checkConnectionOrThrow(MongoClient client) {
        client.listDatabases(); // this will either succeed super fast or explode
        System.out.println(client.listDatabases());
        log.info("Database fully started ...");
    }
}