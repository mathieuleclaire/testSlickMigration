import java.io.File

import slick.migration.api._
import slick.driver.H2Driver.api._
import slick.lifted.TableQuery

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/*
 * Copyright (C) 23/02/17 // mathieu.leclaire@openmole.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

object TestMigration extends App {

  val location = "/tmp/h2"
  lazy val db: Database = Database.forDriver(
    driver = new org.h2.Driver,
    url = s"jdbc:h2:/${location}"
  )

  val users = TableQuery[Users]


  args.head match {
    case "0" =>
      println("CREATE")
//      val query =
//        DBIO.seq(
//          users.schema.create,
//          users += User("1", "Tom"),
//          users += User("2", "Mat")
//        )
//      try {
//        Await.result(
//          db.run(query), Duration.Inf)
//      } finally {
//        println("finally")
//        db.close
//      }
    case _ =>
          println("UPDATE")
          implicit val dialect = new H2Dialect
          val init = TableMigration(users)
            .addColumns(_.toto)
          db.run(init()).foreach { x =>
            println("FINISHED " + x)
          }
  }

}
