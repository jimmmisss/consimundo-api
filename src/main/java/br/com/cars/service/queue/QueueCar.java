package br.com.cars.service.queue;

import br.com.cars.document.Car;
import br.com.cars.exceptions.BusinessException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public abstract class QueueCar {

    private QueueCar() {
        super();
    }

    public static String sendObjectsQueueString(List<Car> cars) {
        final var obj = new ObjectMapper();
        String json;
        try {
            json = obj.writeValueAsString(cars);
        } catch (JsonProcessingException e) {
            throw new BusinessException("Erro ao transformar objeto para string", e);
        }
        return json;
    }
}
