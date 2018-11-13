package com.test.mongo.mongoconnection;

import org.bson.Document;

import com.mongodb.CursorType;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017/test?replicaSet=rs0");
        
        MongoClient mongoclient = new MongoClient(connectionString);
        
        MongoDatabase mongodatabase = mongoclient.getDatabase("local");
        
        MongoCollection<Document> collection = mongodatabase.getCollection("oplog.rs");
               
        Document query = new Document(); //here use { indexedField: { $gt: <lastvalue> } index is not used(except for auto deleting documents) but created in capped collection
        	Document projection = new Document();
        	MongoCursor<Document> cursor= collection
        			.find(query)
        			.projection(projection)
        			.cursorType(CursorType.TailableAwait)
        			.noCursorTimeout(true)
        			.iterator();  //add .noCursorTimeout(true) here to avoid timeout if you are working on big data

        	while (cursor.hasNext()){
        	    Document doc = cursor.next();
        	    //do what you want with doc
        	    System.out.println("\n printing next document \n");
                System.out.println(doc.toJson());
        	
        	}

        Document myDoc = collection.find().first();
        
        System.out.println(myDoc);
        
        System.out.println(collection.count());
        
        mongoclient.close();
    }
}
