package caro.database.mongoDB

import caro.dao.DAOInterface
import org.mongodb.scala.*
import org.mongodb.scala.bson.BsonDocument
import caro.database.DatabaseInterface

class MongoDBImpl() extends DatabaseInterface:

  val mongoDB_host: String = sys.env.getOrElse("MONGODB_HOST", "localhost")
  val mongoDB_port: Int = sys.env.getOrElse("MONGODB_PORT", "27017").toInt
  val uri: String = s"mongodbmongodb://$mongoDB_host:$mongoDB_port"
  System.setProperty("org.mongodb.async.type", "netty")
  val client: MongoClient = MongoClient(uri)
  val db: MongoDatabase = client.getDatabase("test")
  db.createCollection("newCollection")
  val collection: MongoCollection[BsonDocument] = db.getCollection("newCollection")
  val testdoc = BsonDocument("{name: whatever}")
  collection.insertOne(testdoc)
  collection.find().first().toString

  def saveToDB(dao: DAOInterface): Unit = {
  }

  def loadFromDB(): DAOInterface =  {
  }
end MongoDBImpl