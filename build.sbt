/** *****************************************/
/** ********* PROJECT INFO ******************/
/** *****************************************/
name := "scala_bootstrap"
version := "1.0"

/** *********************************************/
/** ********* PROJECT SETTINGS ******************/
/** *********************************************/
Configuration.settings

/** *********************************************/
/** ********* PROD DEPENDENCIES *****************/
/** *********************************************/
libraryDependencies ++= Seq(
  "com.github.nscala-time" %% "nscala-time" % "2.12.0",
  "com.lihaoyi" %% "pprint" % "0.4.1"
)

/** *********************************************/
/** ********* TEST DEPENDENCIES *****************/
/** *********************************************/
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.0" % Test,
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % Test
)

/** *********************************************/
/** ********* COMMANDS ALIASES ******************/
/** *********************************************/
addCommandAlias("t", "test")
addCommandAlias("to", "testOnly")
addCommandAlias("tq", "testQuick")
addCommandAlias("tsf", "testShowFailed")

addCommandAlias("c", "compile")
addCommandAlias("tc", "test:compile")

addCommandAlias("s", "scalastyle")
addCommandAlias("ts", "test:scalastyle")
