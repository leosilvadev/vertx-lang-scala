/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.mongo.{MongoGridFsClient => JMongoGridFsClient}
import io.vertx.core.buffer.Buffer
import io.vertx.core
import io.vertx.core.streams
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.mongo.{GridFsUploadOptions => JGridFsUploadOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.mongo.{GridFsDownloadOptions => JGridFsDownloadOptions}
import io.vertx.core.streams.{WriteStream => JWriteStream}
package object mongo{


  type AggregateOptions = io.vertx.ext.mongo.AggregateOptions
  object AggregateOptions {
    def apply() = new AggregateOptions()
    def apply(json: JsonObject) = new AggregateOptions(json)
  }



  type BulkOperation = io.vertx.ext.mongo.BulkOperation
  object BulkOperation {
    def apply(json: JsonObject) = new BulkOperation(json)
  }



  type BulkWriteOptions = io.vertx.ext.mongo.BulkWriteOptions
  object BulkWriteOptions {
    def apply() = new BulkWriteOptions()
    def apply(json: JsonObject) = new BulkWriteOptions(json)
  }



  type FindOptions = io.vertx.ext.mongo.FindOptions
  object FindOptions {
    def apply() = new FindOptions()
    def apply(json: JsonObject) = new FindOptions(json)
  }



  type GridFsDownloadOptions = io.vertx.ext.mongo.GridFsDownloadOptions
  object GridFsDownloadOptions {
    def apply() = new GridFsDownloadOptions()
    def apply(json: JsonObject) = new GridFsDownloadOptions(json)
  }



  type GridFsUploadOptions = io.vertx.ext.mongo.GridFsUploadOptions
  object GridFsUploadOptions {
    def apply() = new GridFsUploadOptions()
    def apply(json: JsonObject) = new GridFsUploadOptions(json)
  }



  type IndexModel = io.vertx.ext.mongo.IndexModel
  object IndexModel {
    def apply(json: JsonObject) = new IndexModel(json)
  }



  type IndexOptions = io.vertx.ext.mongo.IndexOptions
  object IndexOptions {
    def apply() = new IndexOptions()
    def apply(json: JsonObject) = new IndexOptions(json)
  }




  /**
    * A Vert.x service used to interact with MongoDB server instances.
    * 
    * Some of the operations might change <i>_id</i> field of passed  document.
    */

  implicit class MongoClientScala(val asJava: io.vertx.ext.mongo.MongoClient) extends AnyVal {

    /**
     * Save a document in the specified collection with the specified write option
     * 
     * This operation might change <i>_id</i> field of <i>document</i> parameter     * @param collection the collection
     * @param document the document
     * @param writeOption the write option to use
     * @param resultHandler result handler will be provided with the id if document didn't already have one
     */
  def saveWithOptions(collection: java.lang.String, document: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption], resultHandler: AsyncResult[java.lang.String] => Unit) = {
      asJava.saveWithOptions(collection, document, writeOption.getOrElse(null), resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
  }

    /**
     * Insert a document in the specified collection with the specified write option
     * 
     * This operation might change <i>_id</i> field of <i>document</i> parameter     * @param collection the collection
     * @param document the document
     * @param writeOption the write option to use
     * @param resultHandler result handler will be provided with the id if document didn't already have one
     */
  def insertWithOptions(collection: java.lang.String, document: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption], resultHandler: AsyncResult[java.lang.String] => Unit) = {
      asJava.insertWithOptions(collection, document, writeOption.getOrElse(null), resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
  }

    /**
     * Find a single matching document in the specified collection
     * 
     * This operation might change <i>_id</i> field of <i>query</i> parameter     * @param collection the collection
     * @param query the query used to match the document
     * @param fields the fields
     * @param resultHandler will be provided with the document, if any
     */
  def findOne(collection: java.lang.String, query: io.vertx.core.json.JsonObject, fields: scala.Option[io.vertx.core.json.JsonObject], resultHandler: AsyncResult[io.vertx.core.json.JsonObject] => Unit) = {
      asJava.findOne(collection, query, fields.getOrElse(null), resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
  }

    /**
     * Remove matching documents from a collection with the specified write option and return the handler with MongoClientDeleteResult result     * @param collection the collection
     * @param query query used to match documents
     * @param writeOption the write option to use
     * @param resultHandler will be called when complete
     */
  def removeDocumentsWithOptions(collection: java.lang.String, query: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption], resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit) = {
      asJava.removeDocumentsWithOptions(collection, query, writeOption.getOrElse(null), resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]]])
  }

    /**
     * Remove a single matching document from a collection with the specified write option and return the handler with MongoClientDeleteResult result     * @param collection the collection
     * @param query query used to match document
     * @param writeOption the write option to use
     * @param resultHandler will be called when complete
     */
  def removeDocumentWithOptions(collection: java.lang.String, query: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption], resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit) = {
      asJava.removeDocumentWithOptions(collection, query, writeOption.getOrElse(null), resultHandler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]]])
  }

    /**
     * Like save from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def saveFuture(collection: java.lang.String, document: io.vertx.core.json.JsonObject) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.save(collection, document, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like saveWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def saveWithOptionsFuture(collection: java.lang.String, document: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.saveWithOptions(collection, document, writeOption.getOrElse(null), new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like insert from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def insertFuture(collection: java.lang.String, document: io.vertx.core.json.JsonObject) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.insert(collection, document, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like insertWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def insertWithOptionsFuture(collection: java.lang.String, document: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.insertWithOptions(collection, document, writeOption.getOrElse(null), new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like updateCollection from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def updateCollectionFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientUpdateResult]/*io.vertx.ext.mongo.MongoClientUpdateResult OTHER*/()
      asJava.updateCollection(collection, query, update, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like updateCollectionWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def updateCollectionWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientUpdateResult]/*io.vertx.ext.mongo.MongoClientUpdateResult OTHER*/()
      asJava.updateCollectionWithOptions(collection, query, update, options, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like replaceDocuments from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replaceDocumentsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientUpdateResult]/*io.vertx.ext.mongo.MongoClientUpdateResult OTHER*/()
      asJava.replaceDocuments(collection, query, replace, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like replaceDocumentsWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def replaceDocumentsWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.UpdateOptions) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientUpdateResult]/*io.vertx.ext.mongo.MongoClientUpdateResult OTHER*/()
      asJava.replaceDocumentsWithOptions(collection, query, replace, options, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bulkWrite from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bulkWriteFuture(collection: java.lang.String, operations: scala.collection.mutable.Buffer[io.vertx.ext.mongo.BulkOperation]) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientBulkWriteResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientBulkWriteResult]/*io.vertx.ext.mongo.MongoClientBulkWriteResult OTHER*/()
      asJava.bulkWrite(collection, operations.asJava, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like bulkWriteWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def bulkWriteWithOptionsFuture(collection: java.lang.String, operations: scala.collection.mutable.Buffer[io.vertx.ext.mongo.BulkOperation], bulkWriteOptions: io.vertx.ext.mongo.BulkWriteOptions) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientBulkWriteResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientBulkWriteResult]/*io.vertx.ext.mongo.MongoClientBulkWriteResult OTHER*/()
      asJava.bulkWriteWithOptions(collection, operations.asJava, bulkWriteOptions, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like find from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]/*java.util.List[io.vertx.core.json.JsonObject] LIST*/()
      asJava.find(collection, query, new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like findWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.FindOptions) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]/*java.util.List[io.vertx.core.json.JsonObject] LIST*/()
      asJava.findWithOptions(collection, query, options, new Handler[AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like findOne from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findOneFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, fields: scala.Option[io.vertx.core.json.JsonObject]) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.findOne(collection, query, fields.getOrElse(null), new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like findOneAndUpdate from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findOneAndUpdateFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.findOneAndUpdate(collection, query, update, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like findOneAndUpdateWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findOneAndUpdateWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, findOptions: io.vertx.ext.mongo.FindOptions, updateOptions: io.vertx.ext.mongo.UpdateOptions) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.findOneAndUpdateWithOptions(collection, query, update, findOptions, updateOptions, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like findOneAndReplace from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findOneAndReplaceFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.findOneAndReplace(collection, query, replace, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like findOneAndReplaceWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findOneAndReplaceWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, findOptions: io.vertx.ext.mongo.FindOptions, updateOptions: io.vertx.ext.mongo.UpdateOptions) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.findOneAndReplaceWithOptions(collection, query, replace, findOptions, updateOptions, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like findOneAndDelete from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findOneAndDeleteFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.findOneAndDelete(collection, query, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like findOneAndDeleteWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findOneAndDeleteWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, findOptions: io.vertx.ext.mongo.FindOptions) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.findOneAndDeleteWithOptions(collection, query, findOptions, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like count from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def countFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.count(collection, query, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like removeDocuments from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeDocumentsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientDeleteResult]/*io.vertx.ext.mongo.MongoClientDeleteResult OTHER*/()
      asJava.removeDocuments(collection, query, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like removeDocumentsWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeDocumentsWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientDeleteResult]/*io.vertx.ext.mongo.MongoClientDeleteResult OTHER*/()
      asJava.removeDocumentsWithOptions(collection, query, writeOption.getOrElse(null), new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like removeDocument from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeDocumentFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientDeleteResult]/*io.vertx.ext.mongo.MongoClientDeleteResult OTHER*/()
      asJava.removeDocument(collection, query, new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like removeDocumentWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeDocumentWithOptionsFuture(collection: java.lang.String, query: io.vertx.core.json.JsonObject, writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]) : scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoClientDeleteResult]/*io.vertx.ext.mongo.MongoClientDeleteResult OTHER*/()
      asJava.removeDocumentWithOptions(collection, query, writeOption.getOrElse(null), new Handler[AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createCollection from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createCollectionFuture(collectionName: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createCollection(collectionName, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like getCollections from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getCollectionsFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]/*java.util.List[java.lang.String] LIST*/()
      asJava.getCollections(new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like dropCollection from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def dropCollectionFuture(collection: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.dropCollection(collection, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createIndex from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createIndexFuture(collection: java.lang.String, key: io.vertx.core.json.JsonObject) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createIndex(collection, key, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createIndexWithOptions from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createIndexWithOptionsFuture(collection: java.lang.String, key: io.vertx.core.json.JsonObject, options: io.vertx.ext.mongo.IndexOptions) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createIndexWithOptions(collection, key, options, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createIndexes from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createIndexesFuture(collection: java.lang.String, indexes: scala.collection.mutable.Buffer[io.vertx.ext.mongo.IndexModel]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createIndexes(collection, indexes.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listIndexes from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listIndexesFuture(collection: java.lang.String) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]/*io.vertx.core.json.JsonArray JSON_ARRAY*/()
      asJava.listIndexes(collection, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like dropIndex from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def dropIndexFuture(collection: java.lang.String, indexName: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.dropIndex(collection, indexName, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like runCommand from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def runCommandFuture(commandName: java.lang.String, command: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]/*io.vertx.core.json.JsonObject JSON_OBJECT*/()
      asJava.runCommand(commandName, command, new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like distinct from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def distinctFuture(collection: java.lang.String, fieldName: java.lang.String, resultClassname: java.lang.String) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]/*io.vertx.core.json.JsonArray JSON_ARRAY*/()
      asJava.distinct(collection, fieldName, resultClassname, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like distinctWithQuery from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def distinctWithQueryFuture(collection: java.lang.String, fieldName: java.lang.String, resultClassname: java.lang.String, query: io.vertx.core.json.JsonObject) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]/*io.vertx.core.json.JsonArray JSON_ARRAY*/()
      asJava.distinctWithQuery(collection, fieldName, resultClassname, query, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createDefaultGridFsBucketService from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createDefaultGridFsBucketServiceFuture() : scala.concurrent.Future[io.vertx.ext.mongo.MongoGridFsClient] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoGridFsClient]/*io.vertx.ext.mongo.MongoGridFsClient API*/()
      asJava.createDefaultGridFsBucketService(new Handler[AsyncResult[io.vertx.ext.mongo.MongoGridFsClient]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoGridFsClient]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like createGridFsBucketService from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createGridFsBucketServiceFuture(bucketName: java.lang.String) : scala.concurrent.Future[io.vertx.ext.mongo.MongoGridFsClient] = {
      val promise = concurrent.Promise[io.vertx.ext.mongo.MongoGridFsClient]/*io.vertx.ext.mongo.MongoGridFsClient API*/()
      asJava.createGridFsBucketService(bucketName, new Handler[AsyncResult[io.vertx.ext.mongo.MongoGridFsClient]] { override def handle(event: AsyncResult[io.vertx.ext.mongo.MongoGridFsClient]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.ext.mongo.MongoClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type MongoClientBulkWriteResult = io.vertx.ext.mongo.MongoClientBulkWriteResult
  object MongoClientBulkWriteResult {
    def apply() = new MongoClientBulkWriteResult()
    def apply(json: JsonObject) = new MongoClientBulkWriteResult(json)
  }



  type MongoClientDeleteResult = io.vertx.ext.mongo.MongoClientDeleteResult
  object MongoClientDeleteResult {
    def apply() = new MongoClientDeleteResult()
    def apply(json: JsonObject) = new MongoClientDeleteResult(json)
  }



  type MongoClientUpdateResult = io.vertx.ext.mongo.MongoClientUpdateResult
  object MongoClientUpdateResult {
    def apply() = new MongoClientUpdateResult()
    def apply(json: JsonObject) = new MongoClientUpdateResult(json)
  }





  implicit class MongoGridFsClientScala(val asJava: io.vertx.ext.mongo.MongoGridFsClient) extends AnyVal {


    /**
     * Like delete from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(id: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.delete(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def downloadByFileNameFuture(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer], fileName: java.lang.String) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.downloadByFileName(stream, fileName, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def downloadByFileNameWithOptionsFuture(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer], fileName: java.lang.String, options: io.vertx.ext.mongo.GridFsDownloadOptions) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.downloadByFileNameWithOptions(stream, fileName, options, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def downloadByIdFuture(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer], id: java.lang.String) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.downloadById(stream, id, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like downloadFile from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def downloadFileFuture(fileName: java.lang.String) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.downloadFile(fileName, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like downloadFileAs from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def downloadFileAsFuture(fileName: java.lang.String, newFileName: java.lang.String) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.downloadFileAs(fileName, newFileName, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like downloadFileByID from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def downloadFileByIDFuture(id: java.lang.String, fileName: java.lang.String) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]/*java.lang.Long BOXED_PRIMITIVE*/()
      asJava.downloadFileByID(id, fileName, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like drop from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def dropFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.drop(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like findAllIds from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findAllIdsFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]/*java.util.List[java.lang.String] LIST*/()
      asJava.findAllIds(new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like findIds from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def findIdsFuture(query: io.vertx.core.json.JsonObject) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]/*java.util.List[java.lang.String] LIST*/()
      asJava.findIds(query, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

  def uploadByFileNameFuture(stream: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer], fileName: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.uploadByFileName(stream, fileName, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def uploadByFileNameWithOptionsFuture(stream: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer], fileName: java.lang.String, options: io.vertx.ext.mongo.GridFsUploadOptions) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.uploadByFileNameWithOptions(stream, fileName, options, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like uploadFile from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def uploadFileFuture(fileName: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.uploadFile(fileName, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like uploadFileWithOptions from [[io.vertx.ext.mongo.MongoGridFsClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def uploadFileWithOptionsFuture(fileName: java.lang.String, options: io.vertx.ext.mongo.GridFsUploadOptions) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]/*java.lang.String STRING*/()
      asJava.uploadFileWithOptions(fileName, options, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type UpdateOptions = io.vertx.ext.mongo.UpdateOptions
  object UpdateOptions {
    def apply() = new UpdateOptions()
    def apply(json: JsonObject) = new UpdateOptions(json)
  }



}
