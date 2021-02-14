package br.com.cars.integration;

import br.com.cars.document.Car;
import br.com.cars.exceptions.IntegrationException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "${api.path.car.v1.host}${api.path.car.v1.basePath}", name = "CarIntegrationV1")
public interface CarIntegrationV1 {

    @GetMapping("${api.path.car.v1.get}")
    List<Car> findAll() throws IntegrationException;

    @GetMapping("${api.path.car.v1.findById}")
    Car findById(@PathVariable("id") String id) throws IntegrationException;

    @PostMapping("${api.path.car.v1.post}")
    Car save(Car car) throws IntegrationException;

    @PutMapping("${api.path.car.v1.put}")
    void update(@PathVariable("id") String id, @RequestBody Car car) throws IntegrationException;

    @DeleteMapping("${api.path.car.v1.delete}")
    void delete(@PathVariable("id") String id) throws IntegrationException;

}
