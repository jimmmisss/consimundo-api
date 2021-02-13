package br.com.cars.config;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Value("${queue.order.name}")
    private String logCarQueue;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Queue queue() {
        return new Queue(logCarQueue, true);
    }
}
