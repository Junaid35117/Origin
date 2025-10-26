package com.napier.devops;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App
{
    public static void main(String[] args)
    {
        // Create a connection string with authentication details
        String uriString = "mongodb://admin:pass123@localhost:27000/?authSource=admin";
        MongoClientURI uri = new MongoClientURI(uriString);

        // Connect to MongoDB using the URI with authentication
        MongoClient mongoClient = new MongoClient(uri);

        // Get a database - will create when we use it
        MongoDatabase database = mongoClient.getDatabase("my_db");

        // Get a collection from the database
        MongoCollection<Document> collection = database.getCollection("test");

        // Create a document to store
        Document doc = new Document("name", "Kevin Sim")
                .append("class", "DevOps")
                .append("year", "2024")
                .append("result", new Document("CW", 95).append("EX", 85));

        // Add document to collection
        collection.insertOne(doc);

        // Check document in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());

        // Close client connection when done (optional but recommended)
        mongoClient.close();
    }
}
