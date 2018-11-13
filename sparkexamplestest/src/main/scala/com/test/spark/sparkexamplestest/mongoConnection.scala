package com.test.spark.sparkexamplestest

  import java.util.logging.Level
  import java.util.logging.Logger

  import org.bson.BsonTimestamp
  import org.bson.Document
  import org.mongodb.scala.MongoClient
  import org.mongodb.scala.MongoCollection
  import org.mongodb.scala.MongoDatabase

  import com.mongodb.CursorType 
  import com.mongodb.client.model.Filters
  import com.mongodb.client.model.Projections
  import org.mongodb.scala.Observer

object mongoConnection {
 
def main(args: Array[String]): Unit = {
  val mongoLogger: Logger = Logger.getLogger("com.mongodb")
  
mongoLogger.setLevel(Level.SEVERE);
/*  
val clusterSettings: ClusterSettings = ClusterSettings.builder().hosts(List(new ServerAddress("localhost:27017"), new ServerAddress("localhost:27017")).asJava).build()
val user: String = "cbhawarlal"
val databasename: String = "test"
val password: Array[Char] = "CHethanCI&@".toCharArray
val credential: MongoCredential = createCredential(user, databasename, password)

val settings: MongoClientSettings = MongoClientSettings.builder()
.clusterSettings(clusterSettings).credentialList(List(credential,credential).asJava).sslSettings(SslSettings.builder().enabled(true).build())
.streamFactoryFactory(NettyStreamFactoryFactory()).build()

println("starting connection")

//val mongoClient: MongoClient = MongoClient(settings)
 * 
 */

  println("starting connection")
val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017/test?replicaSet=rs0")

val database: MongoDatabase = mongoClient.getDatabase("local")

val database1: MongoDatabase = mongoClient.getDatabase("test")

val collection: MongoCollection[Document] = database1.getCollection("buyerCollection")

val collection1: MongoCollection[Document] = database.getCollection("oplog.rs")

val oplogStart: BsonTimestamp = new BsonTimestamp(1,1);

collection.find().subscribe(
    (user: Document) => println("first printing subscribe"+user.toString())
    )
    
val collection12 = collection1.find()
.sort(new Document("$natural", -1))
.projection( Projections
        .fields(Projections.include("ts"), Projections.excludeId())).first
               

println("\nsecondcollection last updated timestamp value "+collection12)

/*val collection13 = 
  collection1.find(Filters.and(
     Filters.exists("fromMigrate", false),
          Filters.or(
                        Filters.eq("op", "i"),
                        Filters.eq("op", "u"),
                        Filters.eq("op", "d")
                  )
            )
       )
.projection(Projections.include("ts", "op", "ns", "o"))
.noCursorTimeout(true)
.cursorType(CursorType.TailableAwait)

 val result = Await.result(collection13.toFuture(), Duration.Inf)
 
 result.foreach(res => println(res.toString()))
 * 
 */

//val cursor: MongoCursor[Document] =

  var cursor=  
  collection1.find(Filters.and(
     Filters.exists("fromMigrate", false),
     Filters.gt("ts", oplogStart),
          Filters.or(
                        Filters.eq("op", "i"),
                        Filters.eq("op", "u"),
                        Filters.eq("op", "d")
                  )
            )
       )
.projection(Projections.include("ts", "op", "ns", "o"))
.oplogReplay(true)
.noCursorTimeout(true)
.cursorType(CursorType.TailableAwait)

//cursor.printResults("tailing mongodb")

//.asInstanceOf[MongoCursor[Document]]
//.asInstanceOf[FindIterable[Document]]
/*
val mongocursor: MongoCursor[Document] = cursor.iterator();

while(mongocursor.hasNext()){
  val doc = mongocursor.next()
  println("printing the next document"+doc)
}
* 
*/


//cursor.batchSize(1).iterator()

cursor.subscribe ( new Observer[Document] {
  override def onNext(result: Document): Unit = println("priting the results from findobservable"+result.toJson())
  override def onError(e: Throwable): Unit = println("Failed" + e.getMessage)
  override def onComplete(): Unit = println("Completed")
})


//mongoClient.close()

println("connection made succesfull")

  }
}

