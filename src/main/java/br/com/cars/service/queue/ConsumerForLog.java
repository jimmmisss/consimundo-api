package br.com.cars.service.queue;

import br.com.cars.document.Car;
import br.com.cars.document.Log;
import br.com.cars.exceptions.BusinessException;
import br.com.cars.reposirory.LogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ConsumerForLog {

    private final LogRepository logRepository;

    @RabbitListener(queues = {"${queue.order.name}"})
    public void consumer(@Payload String logCar) {

        final var mapper = new ObjectMapper();

        try {
            List<Car> cars = Arrays.asList(mapper.readValue(logCar, Car[].class));
            cars.forEach(car -> {
                final var log = new Log();
                log.setCar_id(car.get_id());
                logRepository.save(log);
            });
        } catch (JsonProcessingException e) {
            throw new BusinessException("Erro ao tranformar obj json para obj string", e);
        }
    }
}
