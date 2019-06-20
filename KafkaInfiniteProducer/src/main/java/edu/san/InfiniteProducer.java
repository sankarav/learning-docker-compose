package edu.san;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * Hello world!
 */
public class InfiniteProducer {
	private static final String KAFKA_HOST = "kafka";
	private static final String TOPIC = "test";

	public static void main(String[] args) throws InterruptedException {

		Properties props = new Properties();
		props.put("bootstrap.servers", KAFKA_HOST + ":9092");
		props.put("acks", "all");
		props.put("retries", 100);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = null;
		while (producer == null) {
			try {
				producer = new KafkaProducer<>(props);
			} catch (org.apache.kafka.common.KafkaException ex) {
				ex.printStackTrace();
			}
		}

		System.out.println("\n\nKafka Producer Initialized....\n\n");

		boolean condition = 100 == 100;
		long i = 0;
		while (condition) {
			String value = String.valueOf(i++);
			System.out.println("Sending Message = " + value);
			producer.send(new ProducerRecord<>(TOPIC, value));
			Thread.sleep(500);
		}

		producer.close();
		System.out.println("Application exited!");
	}
}
