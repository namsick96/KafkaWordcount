import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaBookConsumer1 {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "test-broker01:9092,test-broker02:9092,test-broker03:9092");
        props.put("group.id", "namsick-consumer");
        props.put("enable.auto.commit", "true");
        props.put("auto.offset.reset", "latest");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.LongDeserializer");
        KafkaConsumer<String, Long> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("namsick-topic2"));
        try {
            while (true) {
                ConsumerRecords<String, Long> records = consumer.poll(5);
                for (ConsumerRecord<String, Long> record : records)
                    System.out.printf("Topic: %s, Partition: %s, Offset: %d, Key: %s, Value: %d\n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
            }
        } finally {
            consumer.close();
        }
    }
}