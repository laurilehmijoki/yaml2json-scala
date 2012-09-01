name := "sampleYaml"

version := "0.1"

organization := "yamljson"

libraryDependencies += "org.yaml" % "snakeyaml" % "1.10"

libraryDependencies += "com.google.code.gson" % "gson" % "2.2.2"

mainClass in (Compile, run) := Some("yamljson.Sample")
