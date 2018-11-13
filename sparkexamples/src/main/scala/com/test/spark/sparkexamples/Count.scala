package com.test.spark.sparkexamples
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql

object Count {  
    def main(args: Array[String]) {       
      val conf = new SparkConf().setAppName("count").setMaster("local")  
      
    }      
}