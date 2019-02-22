# Flink
Generating classes using avro tools avro-tools-1.8.1.jar. 
```
java -jar avro-tools-1.8.1.jar compile schema  kommune.avsc .

```

Schema exampls with namespace 
```json
{"namespace":"kommune","type":"record","name":"Data","fields":[{"name":"KOMMUNE_KODE","type":["null","string"],"default":null},{"name":"KOMMUNE_NAVN","type":["null","string"],"default":null},{"name":"KOMMUNE_SOEGENAVN","type":["null","string"],"default":null},{"name":"FRA_DATO","type":["null","string"],"default":null},{"name":"UDGAAET_DATO","type":["null","string"],"default":null}]}

```


```json
 {"namespace": "example.avro",
 "type": "record",
 "name": "User",
 "fields": [
     {"name": "name", "type": "string", "default": ""},
     {"name": "favoriteNumber",  "type": "string", "default": ""},
     {"name": "favoriteColor", "type": "string", "default": ""},
     {"name": "eventType","type": {"name": "EventType","type": "enum", "symbols": ["meeting"] }}
 ]
}

```


```json
{
  "type": "record",
  "name": "Person",
  "namespace": "com.ippontech.kafkatutorials",
  "fields": [
    {
      "name": "firstName",
      "type": "string"
    },
    {
      "name": "lastName",
      "type": "string"
    },
    {
      "name": "birthDate",
      "type": "long"
    }
  ]
}

```


