package br.com.cars.controller;

import br.com.cars.controller.openapi.CarControllerOpenApi;
import br.com.cars.dto.input.CarInputDTO;
import br.com.cars.dto.input.CarInputUpdateDTO;
import br.com.cars.dto.output.CarOutputDTO;
import br.com.cars.exceptions.BusinessException;
import br.com.cars.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(value = "/v1/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CarController implements CarControllerOpenApi {

    private final CarService carService;

    @GetMapping
    @ResponseStatus(OK)
    public List<CarOutputDTO> listAll() throws BusinessException {
        return carService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public CarOutputDTO findById(@PathVariable("id") String id) throws BusinessException {
        return carService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public CarOutputDTO save(@RequestBody CarInputDTO car) throws BusinessException {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    public void update(@PathVariable("id") String id, @RequestBody CarInputUpdateDTO car) throws BusinessException {
        carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") String id) throws BusinessException {
        carService.delete(id);
    }
}
