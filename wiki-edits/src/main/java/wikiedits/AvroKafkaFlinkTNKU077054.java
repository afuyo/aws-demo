package wikiedits;

import join.WindowJoinSampleDataFK;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.formats.avro.registry.confluent.ConfluentRegistryAvroDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import person077.Data;

import java.util.Properties;

public class AvroKafkaFlinkTNKU077054 {

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
                                ConfluentRegistryAvroDeserializationSchema.forSpecific(person077.Data.class, schemaRegistryUrl),
                                config).setStartFromEarliest());



        DataStreamSource<kommune.Data> input054 = env
                .addSource(
                        new FlinkKafkaConsumer011<>(
                                "TNKU054",
                                ConfluentRegistryAvroDeserializationSchema.forSpecific(kommune.Data.class, schemaRegistryUrl),
                                config).setStartFromEarliest());
        //input054.print();
        input.keyBy("KOMMUNE_KODE").print();

      //SingleOutputStreamOperator<String> mapToString = input
        //        .map((MapFunction<Data, String>) SpecificRecordBase::toString);
       // input.coGroup(input054).where(new NameKeySelector2()).equalTo(new NameKeySelector());
       // input.rebalance().print();
       /** FlinkKafkaProducer010<String> stringFlinkKafkaProducer010 = new FlinkKafkaProducer010<>(
                "test4",
                new SimpleStringSchema(),
                config);

        mapToString.addSink(stringFlinkKafkaProducer010);**/


        env.execute("Kafka 0.10 Confluent Schema Registry AVRO Example");
    }

    private static class NameKeySelector implements KeySelector<kommune.Data,String>{
        @Override
        public String getKey(kommune.Data value) {
            return value.KOMMUNE_KODE.toString();
        }
    }

    private static class NameKeySelector2 implements KeySelector<person077.Data,String>{
        @Override
        public String getKey(person077.Data value) {
            return value.KOMMUNE_KODE.toString();
        }
    }
}

