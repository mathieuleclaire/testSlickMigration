
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


import slick.driver.H2Driver.api._

case class User(id: String, name: String, toto: String)

class Users(tag: Tag) extends Table[User](tag, "USERS") {
  def id = column[String]("ID", O.PrimaryKey)

  def name = column[String]("NAME")

   def toto = column[String]("TOTO")

  def * = {
    val shValues = (id, name, toto).shaped
    shValues.<>({
      tuple =>
        User.apply(
          id = tuple._1,
          name = tuple._2,
          toto = tuple._3
        )
    }, {
      (u: User) =>
        Some((
          u.id,
          u.name,
          u.toto
        ))
    }
    )
  }

}