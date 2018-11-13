package com.test.mongo.mongoconnection;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.changestream.ChangeStreamDocument;

public class mongoStreamDev {

	 public static void main( String[] args )
	    {
	
		 System.out.println("Hello this is the program to stream mongooppbuyer to hbase");
		 
		 MongoClientURI connectionString = new MongoClientURI("mongodb://adasuser:$$M$AN10@fe-mongo01.dev.slc1.ccmteam.com:27017,fe-mongo02.dev.slc1.ccmteam.com:27017,fe-mongo04.dev.slc1.ccmteam.com:27017/ccmIntelligence-dev?replicaSet=fersdev");
		    
		    MongoClient mongoclient = new MongoClient(connectionString);
		    
		    MongoDatabase mongodatabase = mongoclient.getDatabase("ccmIntelligence-dev");
		    
		    MongoCollection<Document> collection = mongodatabase.getCollection("ccm_abcd");
		    
		    MongoCursor<ChangeStreamDocument<Document>> cursor = collection.watch().iterator();
		    
		    while (cursor.hasNext()){
//			    Document doc = cursor.next();
			    
			    ChangeStreamDocument<Document> next = cursor.next();
			    //do what you want with doc
			    System.out.println("\n printing next document \n");
		        System.out.println(next);
			
			}
		    
		    mongoclient.close();
		    
	    }
	
}
