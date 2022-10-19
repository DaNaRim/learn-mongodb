package com.danarim;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Main {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://admin:RCeA3mhKdihhj4j5@cluster0.vqejq0l.mongodb.net/?retryWrites=true&w=majority")) {
            System.out.println("Connected to MongoDB!");

            for (String listDatabaseName : mongoClient.listDatabaseNames()) {
                System.out.println(listDatabaseName);
            }

            MongoDatabase database = mongoClient.getDatabase("test");

//            database.createCollection("createdTestCollection");

            for (String listCollectionName : database.listCollectionNames()) {
                System.out.println(listCollectionName);
            }

            MongoCollection<Document> collection = database.getCollection("createdTestCollection");

            Document document = new Document();
            document.put("name", "Evgeniy");
            document.put("age", 20);
            document.put("address", "Seoul");

            collection.insertOne(document);
            collection.find().forEach(System.out::println);
        }
    }
}
