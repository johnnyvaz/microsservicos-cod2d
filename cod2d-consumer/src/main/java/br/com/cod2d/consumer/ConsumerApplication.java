package br.com.cod2d.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("br.com.cod2d.consumer")
@EnableFeignClients(basePackages = "br.com.cod2d.consumer.config.client")
public class ConsumerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
