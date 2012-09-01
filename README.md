# YAML to JSON sample in Scala

This project contains examples of transforming YAML into JSON and JSON into YAML.

## Usage

`sbt run`

... and the output should be something like this:


    Source string:

        key: val
        map:
          level1a: l1v
          level1b:
            level2a: l2v
          level1c:
            - level2b
            - level2c
        
    As Scala map:
    {key=val, map={level1a=l1v, level1b={level2a=l2v}, level1c=[level2b, level2c]}}

    As string:
    key: val
    map:
      level1a: l1v
      level1b: {level2a: l2v}
      level1c: [level2b, level2c]


    As json:
    {
      "key": "val",
      "map": {
        "level1a": "l1v",
        "level1b": {
          "level2a": "l2v"
        },
        "level1c": [
          "level2b",
          "level2c"
        ]
      }
    }
    
    YAML string -> JSON string -> YAML string succeeded
