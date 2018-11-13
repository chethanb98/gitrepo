package com.test.spark.sparkexamplestest

import org.apache.spark._
import org.apache.spark.sql.SparkSession

object sparkStreaming {

  def main(args: Array[String]){
  
  
val spark = SparkSession
  .builder
  .appName("StructuredNetworkWordCount")
  .getOrCreate()
  

  val ds1 = spark
  .readStream
  .format("kafka")
  .option("kafka.bootstrap.servers", "localhost:9092")
  .option("subscribe", "my-kafka-topic")
  .load()
  
  ds1.printSchema()
  
  /*
  val ds1 = spark.readStream
  .format("socket")
  .option("host", "localhost")
  .option("port", 9999)
  .load()

  */
  
  import spark.implicits._
  
  val words = ds1.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
  
  val wordCounts = words.groupBy("value").count()
  
  //println("reading spark streaming")
  
  //ds1.collect().foreach(println)
 
  val query = wordCounts.writeStream
  .outputMode("complete")
  .format("console")
  .start()

query.awaitTermination()

  }  
}