package wikiedits;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.formats.avro.registry.confluent.ConfluentRegistryAvroDeserializationSchema;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import person077.Data;

import java.util.Properties;

public class AvroKafkaFlinkTNKU077054JoinKeyBy {

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
        env.setStreamTimeCharacteristic(TimeCharacteristic.IngestionTime);

        env.getConfig().disableSysoutLogging();



        DataStreamSource<person077.Data> input = env
                .addSource(
                        new FlinkKafkaConsumer011<>(
                                "TNKU077",
                                ConfluentRegistryAvroDeserializationSchema.forSpecific(Data.class, schemaRegistryUrl),
                                config).setStartFromEarliest());



        DataStreamSource<kommune.Data> input054 = env
                .addSource(
                        new FlinkKafkaConsumer011<>(
                                "TNKU054",
                                ConfluentRegistryAvroDeserializationSchema.forSpecific(kommune.Data.class, schemaRegistryUrl),
                                config).setStartFromEarliest());
        //input054.rebalance().print();


      //SingleOutputStreamOperator<String> mapToString = input
        //        .map((MapFunction<Data, String>) SpecificRecordBase::toString);
       // input.coGroup(input054).where(new NameKeySelector2()).equalTo(new NameKeySelector());
       // input.rebalance().print();
       /** FlinkKafkaProducer010<String> stringFlinkKafkaProducer010 = new FlinkKafkaProducer010<>(
                "test4",
                new SimpleStringSchema(),
                config);

        mapToString.addSink(stringFlinkKafkaProducer010);**/

        DataStream<Tuple3<String, Integer, String>> joinedStream = runWindowJoin(input, input054, 2000L);

        // print the results with a single thread, rather than in parallel
        input.print();
        joinedStream.print().setParallelism(1);
        env.execute("Kafka 0.10 Confluent Schema Registry AVRO Example");
    }


    public static DataStream<Tuple3<String, Integer, String>> runWindowJoin(
            DataStream<Data> grades,
            DataStream<kommune.Data> salaries,
            long windowSize) {

        return grades.join(salaries)
                .where(new NameKeySelector())
                .equalTo(new NameKeySelector2())

                .window(TumblingEventTimeWindows.of(Time.milliseconds(windowSize)))


                .apply(new JoinFunction<Data, kommune.Data, Tuple3<String, Integer, String>>() {

                    @Override
                    public Tuple3<String, Integer, String> join(
                            Data first,
                            kommune.Data second) {
                        return new Tuple3<String, Integer, String>(first.getKVHX().toString(), first.getKOMMUNEKODE(), second.getKOMMUNENAVN().toString());
                    }
                });
    }


    private static class NameKeySelector implements KeySelector<Data,String>{
        @Override
        public String getKey(Data value) {
            return value.getKOMMUNEKODE().toString() ;
        }
    }

    private static class NameKeySelector2 implements KeySelector<kommune.Data,String>{
        @Override
        public String getKey(kommune.Data value) {
            return value.KOMMUNE_KODE.toString();
        }
    }
}

