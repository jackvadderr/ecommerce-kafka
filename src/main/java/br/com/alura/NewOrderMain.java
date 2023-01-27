package br.com.alura;

import java.util.UUID;

public class NewOrderMain {
    public static void main(String[] args)throws Exception {
        try(var dispatcher = new KafkaDispatcher()) {
            for (var i = 0; i < 10; i++) {
                var key = UUID.randomUUID().toString();
                var value = key + "132123,67523,1234589745";
                dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
                var email = "Thank you for your order! We are processing your order!";
                //var emailRecord = new ProducerRecord<>("ECOMMERCE_SEND_EMAIL", key, value);
                dispatcher.send("ECOMMERCE_SEND_EMAIL", key, value);
            }
        }
    }
}
