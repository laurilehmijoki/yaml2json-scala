name := "sampleYaml"

version := "0.1"

organization := "yamljson"

libraryDependencies += "org.yaml" % "snakeyaml" % "1.10"

libraryDependencies += "io.backchat.jerkson" % "jerkson_2.9.1" % "0.7.0"

libraryDependencies += "org.scalaj" %% "scalaj-collection" % "1.2"

mainClass in (Compile, run) := Some("yamljson.Sample")
