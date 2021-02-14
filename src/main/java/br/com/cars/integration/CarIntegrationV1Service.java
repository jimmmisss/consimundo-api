package br.com.cars.integration;

import br.com.cars.document.Car;
import br.com.cars.exceptions.IntegrationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CarIntegrationV1Service {

    private final CarIntegrationV1 carIntegrationV1;

    public List<Car> listAll() {
        try {
            return carIntegrationV1.findAll();
        } catch (Exception e) {
            log.warn("exhausted attempts - listAll {}", CarIntegrationV1.class);
            throw new IntegrationException("Integration fails - list car", e);
        }
    }

    public Car findById(String id) {
        try {
            return carIntegrationV1.findById(id);
        } catch (Exception e) {
            log.warn("exhausted attempts - findById {}", CarIntegrationV1.class);
            throw new IntegrationException("Integration fails - find one car", e);
        }
    }

    public Car save(Car car) {
        try {
            return carIntegrationV1.save(car);
        } catch (Exception e) {
            log.warn("exhausted attempts - save {}", CarIntegrationV1.class);
            throw new IntegrationException("Integration fails - save car ", e);
        }
    }

    public void update(String id, Car car) {
        try {
            carIntegrationV1.update(id, car);
        } catch (Exception e) {
            log.warn("exhausted attempts - update {}", CarIntegrationV1.class);
            throw new IntegrationException("Integration fails - update car ", e);
        }
    }

    public void delete(String id) {
        try {
            carIntegrationV1.delete(id);
        } catch (Exception e) {
            log.warn("exhausted attempts - delete {}", CarIntegrationV1.class);
            throw new IntegrationException("Integration fails - deletar car ", e);
        }
    }

}
