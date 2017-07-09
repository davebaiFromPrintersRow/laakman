name := "cracking-laakman-mcdowell-exercises"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
    exclude("junit", "junit-dep")
)