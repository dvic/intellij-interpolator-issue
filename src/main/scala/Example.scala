object Example extends App {

  import doobie.imports._
  import cats.implicits._
  import fs2.interop.cats._

  val xa = DriverManagerTransactor[IOLite]("org.postgresql.Driver", "jdbc:postgresql:world", "postgres", "")

  val p = {
    val a = sql"select 42".query[Int].unique
    val b = sql"select random()".query[Double].unique

    val c1 = fr"select random()"
    val c2 = fr"+ 1"
    val c = (c1 ++ c2).query[Double].unique
    (a |@| b |@| c).tupled
  }

  println(p.transact(xa).unsafePerformIO)
}
