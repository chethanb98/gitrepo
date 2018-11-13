package com.test.spark.sparkexamplestest
import org.apache.spark.sql.SparkSession
import com.mongodb.spark.config._
import org.apache.spark.sql.DataFrame
import com.mongodb.spark.MongoSpark
import org.apache.spark.sql.catalyst.analysis.TypeCoercion
import org.apache.spark.util.CollectionAccumulator
import org.apache.commons.lang.exception.ExceptionUtils
import org.apache.spark.sql.Row
import com.test.spark.util.Emailsender
import java.time._
import java.util.Date
import java.text.SimpleDateFormat

object wordcount {
  
 def main(args: Array[String]){
    
    val spark =SparkSession
    .builder()
    .appName("chethantest")
    .master("local")
    .getOrCreate()
    
     val readConfigOppBuyer = ReadConfig(Map("uri" -> "mongodb://localhost:27017",
         "collection" -> "buyerCollection",
         "database" -> "test"))
         
     val data = spark.read.csv("//Users/cbhawarlal/test/NBA_player_of_the_week.csv")
    
     data.take(10).foreach(println)
    
         def printExceptions(acc: CollectionAccumulator[(Any)]): Unit = {
  acc.value.toArray.foreach { case (i: Any) =>
    // using org.apache.commons.lang3.exception.ExceptionUtils
     
    println(s"--- Exception on input: $i :") // ExceptionUtils.getStackTrace(e) for full stack trace
  }
}
    
  

         
val oppBuyerMongoDF1: DataFrame = MongoSpark.load(spark, readConfigOppBuyer)

val exceptionAxxumlator: CollectionAccumulator[(Any)] = spark.sparkContext.collectionAccumulator[(Any)]("exceptions")

exceptionAxxumlator.add("test1")
exceptionAxxumlator.add("test2")

oppBuyerMongoDF1.count()

val localDateNow: LocalDate  = LocalDate.now()
      
print("current time"+localDateNow.toString())

localDateNow.toString()

val localdate = new Date()

val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

val targetformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")

 print("parsed date"+format.format(localdate))
   

printExceptions(exceptionAxxumlator)

//Emailsender.sendemail()

oppBuyerMongoDF1.show()

    
 }
}

case class CcmOpportunityBuyer(
  _id:              String,
  user_id:          String,
  user_original_id: String,
  user_guid:        String,
  org_guid:         String,
  user_dw_id:       Option[Long],
  tenant_id:        Long,
  opp_tenant_id:    Option[Long],
  opp_id:           String,
  createdByUser:    Map[String, String],
  updatedByUser:    Map[String, Option[String]],
  status:           String,
  role_names:       Array[String],
  role_key:         Option[Long],
  email:            Option[String],
  isSystemAdded:    Option[Boolean],
  opp_source:   String,
  original_source:  String,
  source: String
)    