/*
 * Copyright 2017 ABSA Group Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql

import org.apache.spark.sql.execution.datasources.jdbc.{JDBCOptions, JDBCRelation => SparkJDBCRelation}
import org.apache.spark.sql.sources.BaseRelation

/**
  * The object represents a value extractor for [[org.apache.spark.sql.execution.datasources.jdbc.JDBCRelation JDBCRelation]].
  */
object JDBCRelation {

  /**
    * The method extracts [[org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions JDBCOptions]] from [[org.apache.spark.sql.execution.datasources.jdbc.JDBCRelation JDBCRelation]].
    * @param rel the subject of value extraction
    * @return An option of [[org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions JDBCOptions]]
    */
  def unapply(rel: BaseRelation): Option[JDBCOptions] = rel match {
    case SparkJDBCRelation(_, jdbcOpts) => Some(jdbcOpts)
    case _ => None
  }
}
