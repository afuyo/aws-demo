package wikiedits;

import person077.Data;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.formats.avro.registry.confluent.ConfluentRegistryAvroDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import java.util.Properties;

public class AvroKafkaFlinkTNKU077 {

    public static void main(String[] args) throws Exception {


        // parse input arguments
        final ParameterTool parameterTool = ParameterTool.fromArgs(args);

     /**   if (parameterTool.getNumberOfParameters() < 6) {
            System.out.println("Missing parameters!\n" +
                    "Usage: Kafka --input-topic <topic> --output-topic <topic> " +
                    "--bootstrap.servers <kafka brokers> " +
                    "--zookeeper.connect <zk quorum> " +
                    "--schema-registry-url <confluent schema registry> --group.id <some id>");
            return;
        }**/
        Properties config = new Properties();
        config.setProperty("bootstrap.servers", "localhost:9092");
        config.setProperty("group.id", "flinkGroupId");
        config.setProperty("zookeeper.connect", "localhost:2181");
        String schemaRegistryUrl = "http://localhost:8081";

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.getConfig().disableSysoutLogging();

        DataStreamSource<Data> input = env
                .addSource(
                        new FlinkKafkaConsumer011<>(
                                "TNKU077",
                                ConfluentRegistryAvroDeserializationSchema.forSpecific(Data.class, schemaRegistryUrl),
                                config).setStartFromEarliest());

        input.rebalance().print();

      SingleOutputStreamOperator<String> mapToString = input
                .map((MapFunction<Data, String>) SpecificRecordBase::toString);

       /** FlinkKafkaProducer010<String> stringFlinkKafkaProducer010 = new FlinkKafkaProducer010<>(
                "test4",
                new SimpleStringSchema(),
                config);

        mapToString.addSink(stringFlinkKafkaProducer010);**/
        env.execute("Kafka 0.10 Confluent Schema Registry AVRO Example");
    }
}
