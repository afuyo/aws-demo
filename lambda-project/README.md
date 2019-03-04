# DynamoDB Streams Lambda 
Hello World of DynamoDB Streams with Lambda

## Create function
1.Insert code below into file index.js
```
console.log('Loading function');

exports.handler = function(event, context, callback) {
    console.log(JSON.stringify(event, null, 2));
    event.Records.forEach(function(record) {
        console.log(record.eventID);
        console.log(record.eventName);
        console.log('DynamoDB Record: %j', record.dynamodb);
    });
    callback(null, "message"); 
};
```
2. Create deployment package
```
zip function.zip index.js
```
3. Create a Lambda function with the create-function command with previously created IAM role. 
arn:aws:iam::275813655051:role/lambda-dynamodb-role
```
aws lambda create-function --function-name ProcessDynamoDBRecords \
--zip-file fileb://function.zip --handler index.handler --runtime nodejs8.10 \
--role arn:aws:iam::275813655051:role/lambda-dynamodb-role
```
4. Create DynamoDB with streams. We use this one here
arn:aws:dynamodb:us-east-1:275813655051:table/Post-vrjaksws4fbydiw2yyxrvkukne/stream/2019-01-21T12:42:08.120

```
aws lambda create-event-source-mapping --function-name ProcessDynamoDBRecords --batch-size 3 --starting-position LATEST --event-source arn:aws:dynamodb:us-east-1:275813655051:table/Post-vrjaksws4fbydiw2yyxrvkukne/stream/2019-01-21T12:42:08.120

```
5. Verfiy the function has been created 
```
aws lambda list-event-source-mappings
```
Inserting records into the table should be now visible in CloudFoundation logs. 


## Run
In your IDE, you can run `Main.main()`.
