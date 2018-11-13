package com.test.spark.sparkexamplestest

import java.util.concurrent.TimeUnit

import scala.concurrent.Await
import scala.concurrent.duration.Duration

import org.mongodb.scala._

object Helpers {

  implicit class DocumentObservable[C](val observable: Observable[Document]) extends ImplicitObservable[Document] {
    override val converter: (Document) => String = (doc) => doc.toJson
  }

  implicit class GenericObservable[C](val observable: Observable[C]) extends ImplicitObservable[C] {
    override val converter: (C) => String = (doc) => doc.toString
  }

  trait ImplicitObservable[C] {
    val observable: Observable[C]
    val converter: (C) => String

    def results(): Seq[C] = Await.result(observable.toFuture(), Duration(100, TimeUnit.SECONDS))
    def headResult() = Await.result(observable.head(), Duration(100, TimeUnit.SECONDS))
    
    def printResults(initial: String = ""): Unit = {
      if (initial.length > 0) print(initial)
      results().foreach(res => println(converter(res)))
    }
    def printHeadResult(initial: String = ""): Unit = println(s"${initial}${converter(headResult())}")
  }

}

// insert a document
/*
val document: BsonDocument = new BsonDocument("_id", new BsonInt32(2)).append("x", new BsonInt32(1))
collection.insertOne(document).subscribe((x: Completed) => println("Inserted"))



val replacementDoc: BsonDocument = new BsonDocument("_id", new BsonInt32(2)).append("x", new BsonInt32(2)).append("y", new BsonInt32(3))

// replace a document
collection.replaceOne(Filters.eq("_id", document.getInt32("1")), replacementDoc).subscribe((updateResult: UpdateResult) => println(updateResult))



// find documents
collection.find().collect().subscribe((results: Seq[BsonDocument]) => println(s"Found BsonDocuments: #${results.size}"))
* 
*/

/*
val document: Document = Document("_id" -> 1, "x" -> 1)
val insertObservable: Observable[Completed] = collection.insertOne(document)

insertObservable.subscribe(new Observer[Completed] {
  override def onNext(result: Completed): Unit = println(s"onNext: $result")
  override def onError(e: Throwable): Unit = println(s"onError: $e")
  override def onComplete(): Unit = println("onComplete")
})

val replacementDoc: Document = Document("_id" -> 1, "x" -> 2, "y" -> 3)

// replace a document
collection.replaceOne(Filters.eq("_id", 1), replacementDoc
    ).subscribe((updateResult: UpdateResult) => println(updateResult))
    * 
    */

//collection.find().collect().subscribe((results: Seq[Document]) => println(s"Found: #${results.size}"))
