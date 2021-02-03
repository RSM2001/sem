package com.napier.sem;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class App
{
    public static void main(String[] args)
    {
        // connect to db locally
        MongoClient mongoClient = new MongoClient("localhost", 27000);
        // get a db
        MongoDatabase database = mongoClient.getDatabase("mydb");
        // get collection
        MongoCollection<Document> collection = database.getCollection("test");
        // create doc
        Document doc = new Document("name", "Robbie Mitchell")
                .append("class", "Software Engineering Methods")
                .append("year", "2021")
                .append("result", new Document("cw", 95).append("EX", 85));
        // add doc to collection
        collection.insertOne(doc);

        //check doc in collection
        Document myDoc = collection.find().first();
        System.out.println(myDoc.toJson());
    }
}
