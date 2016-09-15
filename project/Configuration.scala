import sbt.{Tests, _}
import sbt.Keys._

object Configuration {
  val settings = Seq(
    organization := "tv.codely",
    scalaVersion := "2.11.8",

    // Compiler options
    scalacOptions <<= version map { v: String =>
      val default = Seq(
        "-Xlint", // More warnings when compiling
        "-Xfatal-warnings", // Warnings became errors
        "-unchecked", // More warnings. Strict
        "-deprecation", // Warnings deprecation
        "-feature" // Advise features
      )
      if (v.endsWith("SNAPSHOT")) default :+ "-Xcheckinit" else default // Check against early initialization
    },
    javaOptions += "-Duser.timezone=UTC",

    // Test options
    parallelExecution in Test := false,
    testForkedParallel in Test := false,
    fork in Test := true,
    testOptions in Test ++= Seq(
      Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"), // Save test reports
      Tests.Argument("-oDF") // Show full stack traces and time spent in each test
    )
  )
}