package edu.san;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * Hello world!
 */
public class InfiniteConsumer {
	private static final String KAFKA_HOST = "kafka";
	private static final String TOPIC = "test";

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("bootstrap.servers", KAFKA_HOST + ":9092");
		props.put("group.id", InfiniteConsumer.class.getCanonicalName());
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(TOPIC));

		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(100);
//			System.out.println("...");
			for (ConsumerRecord<String, String> record : records)
				System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
		}
	}
}
