package mongodb;

import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


public class ConnectToDB {
	
	public static void main(String args[]) {
		// Creating a Mongo client 
	    MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
//	    MongoCredential credential = MongoCredential.createCredential(null, "school", null);
	 // Accessing the database 
	      MongoDatabase database = mongo.getDatabase("school"); 
	      
	      
	      
	      MongoCollection<Document> studentsCollection = database.getCollection("students"); 
	      
	      studentsCollection.updateOne(Filters.eq("StudentNo", "1"), Updates.set("FirstName", "Aki"));
	      
	      System.out.println(studentsCollection.count());
//	      Document document = new Document("StudentNo","4").append("FirstName", "Deeya").append("LAstName", "Nagpal").append("Age", "3");
//	      studentsCollection.insertOne(document);
	      
	      Iterator<Document> itr = studentsCollection.find().iterator();
	      
	      while(itr.hasNext()) {
	    	  System.out.println(((Document)itr.next()).get("5ab2de5ae7ceda659e2d378a"));
	      }
	      
	      for(String name:database.listCollectionNames()) {
	    	  System.out.println("Collection Name :"+name);
	      }
	}
	
	

}
