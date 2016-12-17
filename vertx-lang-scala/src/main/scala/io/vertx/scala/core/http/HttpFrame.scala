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

package io.vertx.scala.core.http

import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}

/**
  * An HTTP/2 frame.
  */
class HttpFrame(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JHttpFrame]
//methods returning a future
//cached methods
  def type():Int = {
    asJava.type( )
  }

  def flags():Int = {
    asJava.flags( )
  }

  def payload():Buffer = {
    asJava.payload( )
  }

//fluent methods
//basic methods
}

object HttpFrame{
//in object!
//static methods
}
