package yamljson

import org.yaml.snakeyaml._
import com.google.gson._

object Sample {
  def main(args: Array[String]) {
    println("Source string:\n" + yamlStr)
    printYaml
    printJson
  }

  def printJson = {
    val gson = (new GsonBuilder).setPrettyPrinting.create
    val yaml = new Yaml
    println("As json:\n" + gson.toJson(yaml.load(yamlStr)) + "\n")
  }

  def printYaml = {
    val yaml = new Yaml
    val yamlMap = yaml.load(yamlStr)
    val yamlString = yaml.dump(yamlMap)
    println("As Scala map:\n" + yamlMap + "\n")
    println("As string:\n" + yamlString + "\n")
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
