package br.com.cars.service;

import br.com.cars.document.Car;
import br.com.cars.dto.input.CarInputDTO;
import br.com.cars.dto.input.CarInputUpdateDTO;
import br.com.cars.dto.output.CarOutputDTO;
import br.com.cars.exceptions.BusinessException;
import br.com.cars.integration.CarIntegrationV1Service;
import br.com.cars.mapper.Mappable;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.cars.service.queue.QueueCar.sendObjectsQueueString;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarService implements Mappable {

    private final CarIntegrationV1Service carIntegrationV1Service;
    private final ModelMapper mapper;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public List<CarOutputDTO> listAll() throws BusinessException {
        final var cars = carIntegrationV1Service.listAll();
        rabbitTemplate.convertAndSend(queue.getName(), sendObjectsQueueString(cars));
        return cars.stream().map(c -> map(c, CarOutputDTO.class)).collect(Collectors.toList());
    }

    public CarOutputDTO findById(String id) throws BusinessException {
        final var car = carIntegrationV1Service.findById(id);
        return map(car, CarOutputDTO.class);
    }

    @Transactional
    public void save(CarInputDTO car) throws BusinessException {
        carIntegrationV1Service.save(mapper.map(car, Car.class));
    }

    @Transactional
    public void update(String id, CarInputUpdateDTO car) throws BusinessException {
        final var carResult = findById(id);
        final var idCar = carResult.get_id();
        car.set_id(idCar);
        carIntegrationV1Service.update(id, map(car, Car.class));
    }

    public void delete(String id) throws BusinessException {
        carIntegrationV1Service.delete(id);
    }

    @Override
    public ModelMapper mapper() {
        return this.mapper;
    }
}
