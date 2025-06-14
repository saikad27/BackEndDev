

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class MongoDBExample {

    public static void main(String[] args) {
        // Connect to MongoDB
        String uri = "mongodb://localhost:27017"; // Use your MongoDB connection string
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(uri))) {

            // Access the database
            MongoDatabase database = mongoClient.getDatabase("schoolDB");

            // Access the collection (create it if it doesn't exist)
            MongoCollection<Document> collection = database.getCollection("Students");

            // 1. Add Operation
            addRecord(collection, "Samay", 1, "A");
            addRecord(collection, "Raj", 24, "B");
            addRecord(collection, "Shanaya", 3, "C");

            // 2. Display Operation
            displayRecords(collection);

            // 3. Update Operation
            updateRecord(collection, "Samay", "class", "B");

            // 4. Delete Operation
            deleteRecord(collection, "Raj");

            // Final display to confirm updates
            System.out.println("\nAfter Update and Delete:");
            displayRecords(collection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to add a new record
    public static void addRecord(MongoCollection<Document> collection, String name, int roll, String studentClass) {
        Document document = new Document("Sname", name)
                .append("roll", roll)
                .append("class", studentClass);
        collection.insertOne(document);
        System.out.println("Record added: " + document.toJson());
    }

    // Method to display all records
    public static void displayRecords(MongoCollection<Document> collection) {
        System.out.println("\nAll Records:");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    // Method to update a specific field of a record
    public static void updateRecord(MongoCollection<Document> collection, String name, String field, Object newValue) {
        collection.updateOne(eq("Sname", name), new Document("$set", new Document(field, newValue)));
        System.out.println("Updated " + field + " for " + name + " to " + newValue);
    }

    // Method to delete a record by name
    public static void deleteRecord(MongoCollection<Document> collection, String name) {
        collection.deleteOne(eq("Sname", name));
        System.out.println("Deleted record with Sname: " + name);
    }
}
