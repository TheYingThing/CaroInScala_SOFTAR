package caro.database.mongoDB

import akka.stream.javadsl.FileIO
import org.mongodb.scala.*
import org.mongodb.scala.bson.BsonDocument
import caro.database.DatabaseInterface
import caro.database.JsonService
import caro.model.gridComponent.BoardInterface
import caro.model.gridComponent.boardFullImpl.Board
import fileIoComponent.fileIoJsonImpl.FileIO
import org.mongodb.scala.model.Projections.*
import org.mongodb.scala.model.Sorts.descending
import org.mongodb.scala.result.InsertOneResult
import org.reactivestreams

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}
import concurrent.duration.{Duration, DurationInt}

class MongoDBImpl() extends DatabaseInterface:
  val uri: String = "mongodb+srv://caro:caro_123@carodb.ydmgk.mongodb.net/CaroPersistence?retryWrites=true&w=majority"
  System.setProperty("org.mongodb.async.type", "netty")
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("CaroPersistence")
  val collection: MongoCollection[Document] = db.getCollection("GameFiles")
  val jsonService: JsonService.type = JsonService

  def saveToDB(board: BoardInterface): Unit = {
    val observable = collection.insertOne(Document.apply("boardFile" -> jsonService.boardToJson(board).toString))
    observable.subscribe(new Observer[InsertOneResult] {
      override def onSubscribe(subscription: reactivestreams.Subscription): Unit = super.onSubscribe(subscription)

      override def onNext(result: InsertOneResult): Unit = println(s"inserted board: $result")

      override def onError(e: Throwable): Unit = println(s"could not insert: ${e.getMessage}")

      override def onComplete(): Unit = println("completed")
    })
  }

  def loadFromDB(): Future[BoardInterface] =  {
    val boardResult = Await.result(collection.find().sort(descending("_id")).first().head(), atMost = 10.second)

    Future{jsonService.loadFromString(boardResult.get("boardFile").get.asString().getValue)}
  }

end MongoDBImpl