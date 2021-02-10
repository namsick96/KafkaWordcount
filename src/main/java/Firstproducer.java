import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;


public class Firstproducer {
    public static void main(String[] args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "test-broker01:9092,test-broker02:9092,test-broker03:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        try{
            producer.send(new ProducerRecord<String, String>("namsick-topic","whole new world"));
            producer.send(new ProducerRecord<String, String>("namsick-topic","IU whole"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            producer.close();
        }
    }
}
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "test-broker01:9092,test-broker02:9092,test-broker03:9092");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        Producer<String, String> producer = new KafkaProducer<>(props);
//        try{
//            producer.send(new ProducerRecord<String, String>("namsick-topic",
//                    "pokemon"));
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            producer.close();
//        }
//    }
//}