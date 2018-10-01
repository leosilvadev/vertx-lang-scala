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

package io.vertx.scala.kafka.client.consumer

import io.vertx.kafka.client.consumer.{OffsetAndMetadata => JOffsetAndMetadata}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Provide additional metadata when an offset is committed

 */

class OffsetAndMetadata(private val _asJava: JOffsetAndMetadata) {
  def asJava = _asJava
  /**
   * Set additional metadata for the offset committed
   */
  def setMetadata(value: String) = {
    asJava.setMetadata(value)
    this
  }

  def getMetadata: String = {
    asJava.getMetadata().asInstanceOf[String]
  }

  /**
   * Set the offset to commit
   */
  def setOffset(value: Long) = {
    asJava.setOffset(value)
    this
  }

  def getOffset: Long = {
    asJava.getOffset().asInstanceOf[Long]
  }

}


object OffsetAndMetadata {
  
  def apply() = {
    new OffsetAndMetadata(new JOffsetAndMetadata(emptyObj()))
  }
  
  def apply(t: JOffsetAndMetadata) = {
    if (t != null) {
      new OffsetAndMetadata(t)
    } else {
      new OffsetAndMetadata(new JOffsetAndMetadata(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): OffsetAndMetadata = {
    if (json != null) {
      new OffsetAndMetadata(new JOffsetAndMetadata(json))
    } else {
      new OffsetAndMetadata(new JOffsetAndMetadata(emptyObj()))
    }
  }
}

