package com.test.spark.sparkexamples


import scala.collection.mutable.ListBuffer
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.SparkSession
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path


object SparkAss {
  
      def main(args:Array[String]){
      
        val path = args(0)
        //path = ""
     // method to sort through list and get next pageUrl        
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
    
    spark.conf.set("spark.hadoop.validateOutputSpecs", "false")
    
    val hdfs = FileSystem.get(spark.sparkContext.hadoopConfiguration)
        
    val rawData = spark.read.json(path) 
    
    import spark.implicits._
    
    val castedData =rawData.map(x => JsonData( x.getAs[String]("id"),x.getAs[String]("timestamp"),x.getAs[String]("type"),x.getAs[String]("visitorId"),x.getAs[String]("pageUrl")))
    .filter(x => (x.visitorId!=null)).distinct()
    
    val rdd_keyVal = castedData.rdd.map(x => (x.visitorId, x))
        
    val grpdata = rdd_keyVal.groupByKey().map(x =>x._2).map(leadLink) 
    
    val result  = grpdata.flatMap(x => x)  
      
    val outputpath = "/Users/cbhawarlal/Downloads/ad-events/result"
    hdfs.delete(new Path(outputpath), true)
    
    result.coalesce(1, true).saveAsTextFile(outputpath)
    
    result.take(100).foreach(println)
      }       
}
case class JsonData( id: String, timestamp:String, eventType :String, visitorId: String,  pageUrl: String) 

case class ResultData( id: String, timestamp:String, eventType :String, visitorId: String,  pageUrl: String, nextPageUrl : String)