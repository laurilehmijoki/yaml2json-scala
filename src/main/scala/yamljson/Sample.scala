package yamljson

import org.yaml.snakeyaml._
import com.codahale.jerkson.Json._
import scalaj.collection.Imports._

object Sample {
  def main(args: Array[String]) {
    println("Source string:\n" + yamlStr)
    printYaml
    printJson
    printYaml2Json2YamlStr
  }

  def printYaml = {
    val yaml = new Yaml
    val yamlMap = yaml.load(yamlStr)
    val yamlString = yaml.dump(yamlMap)
    println("As Scala map:\n" + yamlMap + "\n")
    println("As string:\n" + yamlString + "\n")
  }

  def printJson = {
    val yamlMap = (new Yaml).load(yamlStr)
    val jsonString = generate(yamlMap)
    println("As json:\n" + jsonString + "\n")
  }

  def printYaml2Json2YamlStr = {
    val yamlMap = (new Yaml).
      load(yamlStr).asInstanceOf[java.util.Map[String,_]].asScala // Convert to Scala map
    val jsonString = generate(yamlMap) // Serialise to string with Jerkins
    val jsonMap = parse[Map[String, Any]](jsonString) // Deserialise to map with Jerkins
    jsonMap.equals(yamlMap) match {
      case true  => println("YAML string -> JSON string -> YAML string succeeded")
      case false =>
        throw new RuntimeException("YAML string -> JSON string -> YAML string failed")
    }
  }

  def yamlStr =
    """
    key: val
    map:
      level1a: l1v
      level1b:
        level2a: l2v
      level1c:
        - level2b
        - level2c
    """
}
