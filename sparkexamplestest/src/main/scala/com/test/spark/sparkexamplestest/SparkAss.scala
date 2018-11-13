package com.test.spark.sparkexamplestest

import scala.collection.mutable.ListBuffer
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.SparkSession

object SparkAss extends App{
  
     def leadLink(itr : Iterable[JsonData]) = {
     var listbuf = new ListBuffer[JsonData]()
     var resBuf = new ListBuffer[ResultData]()
     itr.copyToBuffer[JsonData](listbuf)
     var lb2 = listbuf.sortBy(r => r.timestamp)
     for( i <- 0 until lb2.size - 1){
       var tmp = lb2(i)
       resBuf += ResultData(tmp.id , tmp.timestamp, tmp.eventType, tmp.visitorId, tmp.pageUrl, lb2(i+1).pageUrl)
     }
     var tmp = lb2(lb2.size-1) 
     resBuf += ResultData(tmp.id , tmp.timestamp, tmp.eventType, tmp.visitorId, tmp.pageUrl, null)
     resBuf
   } 
  
    val spark =SparkSession.builder().appName("spark assignment").master("local[*]").getOrCreate()
    
    val rawData = spark.read.json("/Users/cbhawarlal/Downloads/ad-events/part-00000-732eeb74-f251-4f96-85d5-5c9ae95ba709-c000.txt") 
    
    import spark.implicits._
    
    val castedData =rawData.map(x => JsonData( x.getAs[String]("id"),x.getAs[String]("timestamp"),x.getAs[String]("type"),x.getAs[String]("visitorId"),x.getAs[String]("pageUrl")))
    .filter(x => (x.visitorId!=null)).distinct()
    
    val rdd_keyVal = castedData.rdd.map(x => (x.visitorId, x))
        
    val grpdata = rdd_keyVal.groupByKey().map(x =>x._2).map(leadLink) 
    
    val result  = grpdata.flatMap(x => x)  
          
    result.coalesce(1, true).saveAsTextFile("/Users/cbhawarlal/Downloads/ad-events/result")
    result.take(100).foreach(println)
       
}
case class JsonData( id: String, timestamp:String, eventType :String, visitorId: String,  pageUrl: String) 

case class ResultData( id: String, timestamp:String, eventType :String, visitorId: String,  pageUrl: String, nextPageUrl : String)
