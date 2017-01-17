name := "intellij-interpolator-issue"

version := "1.0"

scalaVersion := "2.11.8"

val doobie = "0.4.0"

libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core-cats" % doobie,
  "org.tpolecat" %% "doobie-postgres-cats" % doobie
)