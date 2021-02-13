package br.com.cars.integration;

import br.com.cars.document.Car;
import br.com.cars.exceptions.IntegrationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarIntegrationV1Service {

    private final CarIntegrationV1 carIntegrationV1;

    public List<Car> listAll() {
        try {
            return carIntegrationV1.findAll();
        } catch (Exception e) {
            throw new IntegrationException("Integration fails - list car", e);
        }
    }

    public Car findById(String id) {
        try {
            return carIntegrationV1.findById(id);
        } catch (Exception e) {
            throw new IntegrationException("Integration fails - find one car", e);
        }
    }

    public void save(Car car) {
        try {
            carIntegrationV1.save(car);
        } catch (Exception e) {
            throw new IntegrationException("Integration fails - save car ", e);
        }
    }

    public void update(String id, Car car) {
        try {
            carIntegrationV1.update(id, car);
        } catch (Exception e) {
            throw new IntegrationException("Integration fails - update car ", e);
        }
    }

    public void delete(String id) {
        try {
            carIntegrationV1.delete(id);
        } catch (Exception e) {
            throw new IntegrationException("Integration fails - deletar car ", e);
        }
    }

}
