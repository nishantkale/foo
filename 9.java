spackage rfidpro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Rfid {
	public static void main(String[] args) {
		try {

			MongoClient client = new MongoClient("localhost", 27017);
			DB db = client.getDB("demo");
			insertLogsToDatabase(db);
			aggregateRecords(db);
		} catch (UnknownHostException e) {
			System.out.println("Error Caught :" + e.getMessage());

		} catch (IOException e) {
			System.out.println("Error Caught :" + e.getMessage());
		}
	}
	private static void aggregateRecords(DB db) {
		DBCollection collection = db.getCollection("hadoop_logs");
		DBObject object = new BasicDBObject("_id", "$Type");
		object.put("Num_of_Log", new BasicDBObject("$sum", 1));
		DBObject groupObject = new BasicDBObject("$group", object);
		AggregationOutput output = collection.aggregate(groupObject);
		for (DBObject result : output.results()) {
			System.out.println(result);

		}

	}
	private static void insertLogsToDatabase(DB db) throws IOException {
		DBCollection collection = db.getCollection("hadoop_logs");
		DataInputStream in = new DataInputStream(new FileInputStream(
				"logs/hadoop.log"));
		String line = "";
		while ((line = in.readLine()) != null) {
			String array[] = line.split("\t");
			DBObject object = new BasicDBObject("Date", array[0]);
			object.put("Type", array[1]);
			object.put("Message", array[2]);
			collection.insert(object);
		}
	}

}