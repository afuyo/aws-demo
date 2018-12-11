package com.aws.graphQL.awsacorddemo;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;

import java.util.*;
import java.util.stream.IntStream;

public class PutItem3 {

   public static void main(String[] args){

       //AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
       final AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
       DynamoDB dynamoDB = new DynamoDB(client);

       Table table = dynamoDB.getTable("PerfTest1");

       IntStream.iterate(0,i-> i+2).forEach((i)->{

           UUID uuid = UUID.randomUUID();
           String randomUUIDString = uuid.toString();
           // Build the item
           Item item = new Item()
                   .withPrimaryKey("Id", randomUUIDString)
                   .withString("Title", "Bicycle 123")
                   .withString("Description", "123 description")
                   .withString("BicycleType", "Hybrid")
                   .withString("Brand", "Brand-Company C")
                   .withNumber("Price", 500);

           PutItemOutcome outcome = table.putItem(item);

               });

      /** while (true) {
           UUID uuid = UUID.randomUUID();
           String randomUUIDString = uuid.toString();
           // Build the item
           Item item = new Item()
                   .withPrimaryKey("Id", randomUUIDString)
                   .withString("Title", "Bicycle 123")
                   .withString("Description", "123 description")
                   .withString("BicycleType", "Hybrid")
                   .withString("Brand", "Brand-Company C")
                   .withNumber("Price", 500);

           PutItemOutcome outcome = table.putItem(item);
       }**/
   }
}
