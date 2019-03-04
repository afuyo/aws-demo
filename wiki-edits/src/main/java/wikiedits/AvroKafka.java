package wikiedits;

import org.apache.flink.api.common.functions.FoldFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.formats.avro.AvroDeserializationSchema;
import org.apache.flink.formats.avro.registry.confluent.ConfluentRegistryAvroDeserializationSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditEvent;
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditsSource;


import java.util.Properties;

public class AvroKafka {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "wn0-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn1-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn10-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn11-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn2-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn3-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn4-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn5-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092");
        properties.setProperty("zookeeper.connect", "10.94.0.71:2181,10.94.0.27:2181,10.94.0.20:2181");
       // 10.94.0.71 zk3-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net
       // 10.94.0.27 zk5-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net
       // 10.94.0.20 zk6-kaf001.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net
        properties.setProperty("group.id", "statarmFlinkTest");
        AvroDeserializationSchema<Data> avroSchema =  AvroDeserializationSchema.forSpecific(Data.class);
       // AvroDeserializationSchema<Data> avroSchema =  ConfluentRegistryAvroDeserializationSchema.forSpecific(Data.class);

        System.out.println("Hello");
        System.out.println("#####################################################################");
        System.out.println(avroSchema.toString());

        FlinkKafkaConsumer011<Data> kafkaConsumer = new FlinkKafkaConsumer011<>("DB2N.TNKU020", avroSchema, properties);
        DataStream<Data> messageStream = env.addSource(kafkaConsumer);
        messageStream.rebalance().print();
        env.execute("Flink AVRO KAFKA Test");
    }
}
