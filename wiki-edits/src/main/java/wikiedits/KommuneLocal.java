/*
 * Copyright 2017 data Artisans GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package wikiedits;


import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.formats.avro.registry.confluent.ConfluentRegistryAvroDeserializationSchema;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.co.RichCoFlatMapFunction;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.util.Collector;
import person077.Data;

import java.util.Properties;

/**
 * Java reference implementation for the "Stateful Enrichment" exercise of the Flink training
 * (http://training.data-artisans.com).
 *
 * The goal for this exercise is to enrich TaxiRides with fare information.
 *
 * Parameters:
 * -rides path-to-input-file
 * -fares path-to-input-file
 *
 */
public class KommuneLocal extends Base {
	public static SinkFunction out = null;
	public static void main(String[] args) throws Exception {

		Properties config = new Properties();
		config.setProperty("bootstrap.servers", "localhost:9092");
		//config.setProperty("bootstrap.servers","wn0-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn1-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn2-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn3-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn4-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn5-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn6-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092,wn7-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:9092");
		config.setProperty("group.id", "flinkGroupId");
		//config.setProperty("zookeeper.connect","localhost:2181");
		//config.setProperty("zookeeper.connect", "zk0-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:2181,zk2-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:2181,zk3-kaf009.h5arvczbnrpu5hbokqg2ze25qa.ax.internal.cloudapp.net:2181");
		//String schemaRegistryUrl = "http://10.94.0.5:8081";
		String schemaRegistryUrl = "http://localhost:8081";


		// set up streaming execution environment
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.setStreamTimeCharacteristic(TimeCharacteristic.IngestionTime);
		//env.setParallelism(ExerciseBase.parallelism);

		/**DataStream<TaxiRide> rides = env
				.addSource(rideSourceOrTest(new TaxiRideSource(ridesFile, delay, servingSpeedFactor)))
				.filter((TaxiRide ride) -> ride.isStart)
				.keyBy("rideId");

		DataStream<TaxiFare> fares = env
				.addSource(fareSourceOrTest(new TaxiFareSource(faresFile, delay, servingSpeedFactor)))
				.keyBy("rideId");**/

		DataStream<Data> input = env
				.addSource(
						new FlinkKafkaConsumer011<>(
								"TNKU077",
								ConfluentRegistryAvroDeserializationSchema.forSpecific(Data.class, schemaRegistryUrl),
								config)
								.setStartFromEarliest())
				                .keyBy(Data::getKOMMUNEKODEString);




		DataStream<kommune.Data> input054 = env
				.addSource(
						new FlinkKafkaConsumer011<>(
								"TNKU054",
								ConfluentRegistryAvroDeserializationSchema.forSpecific(kommune.Data.class, schemaRegistryUrl),
								config).setStartFromEarliest())
				.keyBy(kommune.Data::getKOMMUNEKODEString);

		DataStream<Tuple2<Data, kommune.Data>> enrichedRides = input
				.connect(input054)
				.flatMap(new EnrichmentFunction());

		printOrTest(enrichedRides);

          // input.print();
		//rides.print();

		//fares.print();

		env.execute("Join Rides with Fares (java RichCoFlatMap)");
	}
	private static class NameKeySelector implements KeySelector<Data,String> {
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

	public static class EnrichmentFunction extends RichCoFlatMapFunction<Data, kommune.Data, Tuple2<Data, kommune.Data>> {
		// keyed, managed state
		private ValueState<Data> rideState;
		private ValueState<kommune.Data> fareState;

		@Override
		public void open(Configuration config) {
			rideState = getRuntimeContext().getState(new ValueStateDescriptor<>("saved ride", Data.class));
			fareState = getRuntimeContext().getState(new ValueStateDescriptor<>("saved fare", kommune.Data.class));
		}

		@Override
		public void flatMap1(Data ride, Collector<Tuple2<Data, kommune.Data>> out) throws Exception {
			kommune.Data fare = fareState.value();
			if (fare != null) {
				//fareState.clear();
				out.collect(new Tuple2(ride, fare));
			} else {
				rideState.update(ride);
			}
		}

		@Override
		public void flatMap2(kommune.Data fare, Collector<Tuple2<Data, kommune.Data>> out) throws Exception {
			Data ride = rideState.value();

			if (ride != null) {
				rideState.clear();
				out.collect(new Tuple2(ride, fare));
			} else {
				fareState.update(fare);
			}
		}
	}
}