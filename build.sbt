lazy val commonSettings = Seq(
  organization := "au.com.adaptic",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.10.5"
)


EclipseKeys.withSource := true

test in assembly := {}



lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "evolution-spark",
    
    libraryDependencies += "org.apache.spark" %% "spark-core" % "1.6.0" % "provided",
    libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.0" % "provided",
    libraryDependencies += "org.apache.spark" %% "spark-hive" % "1.6.0" % "provided",
    libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.4.1" % "provided",
    
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
    libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.12",
    
    libraryDependencies += "org.specs2" %% "specs2-core" % "3.6.4" % "test",
    
	parallelExecution in Test := false

) 


publishTo <<= version { (v: String) =>
  val maven = "s3://au.com.adaptic.maven/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("Adaptic Snapshots" at maven + "snapshots")
  else
    Some("Adaptic Releases" at maven + "releases")
}


initialCommands in console := """
    import org.apache.spark.rdd.RDD
    import org.apache.spark.SparkContext._
"""