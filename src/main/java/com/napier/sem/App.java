package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App {
    public static void main(String[] args) {
        // Connect to MongoDB running on localhost at port 27000
        MongoClient mongoClient = new MongoClient("localhost", 27000);

        // Get the database and collection
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("test");

        // Create a document
        Document doc = new Document("name", "Your Name")
                .append("class", "DevOps")
                .append("year", "2024")
                .append("result", new Document("CW", 95).append("EX", 85));

        // Insert the document
        collection.insertOne(doc);

        // Print the first document from the collection
        System.out.println(collection.find().first().toJson());

        // Close the connection
        mongoClient.close();
    }
}
