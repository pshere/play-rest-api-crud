name := """play-rest-api-crud"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.8"

//libraryDependencies += guice
//libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
//libraryDependencies += "com.typesafe.play"      %% "play-slick"         % "5.0.0"
//
//// Adds additional packages into Twirl
////TwirlKeys.templateImports += "com.example.controllers._"
//
//// Adds additional packages into conf/routes
//// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
//libraryDependencies += guice
//libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
//libraryDependencies += "com.typesafe.play"      %% "play-slick"         % "5.0.0"
//libraryDependencies ++= Seq(
//  "com.typesafe.slick" %% "slick" % "3.3.3",
//  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
//  "org.postgresql" % "postgresql" % "42.3.1",
//  "org.scalikejdbc" %% "scalikejdbc" % "3.4.1",
//  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
//  specs2 % Test
//
//)
//libraryDependencies += "org.specs2" %% "specs2-core" % "4.13.1" % "test"
//libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19"
//libraryDependencies +=  "org.mockito" % "mockito-core" % "1.9.5" % "test"
//libraryDependencies += "javax.inject" % "javax.inject" % "1"
//libraryDependencies += evolutions
////libraryDependencies += guice
//libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
////
libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.3.1",
  "com.typesafe.play" %% "play-slick" % "5.0.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "5.0.0",
  "org.scalikejdbc" %% "scalikejdbc" % "3.4.1",
  "com.typesafe.slick" %% "slick" % "3.3.3"
)
libraryDependencies += specs2 % Test
libraryDependencies += jdbc % Test
libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19"
libraryDependencies +=  "org.mockito" % "mockito-core" % "1.9.5" % "test"
libraryDependencies += "javax.inject" % "javax.inject" % "1"
libraryDependencies += evolutions
