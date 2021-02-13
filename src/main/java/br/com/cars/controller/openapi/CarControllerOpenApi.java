package br.com.cars.controller.openapi;

import br.com.cars.dto.input.CarInputDTO;
import br.com.cars.dto.input.CarInputUpdateDTO;
import br.com.cars.dto.output.CarOutputDTO;
import br.com.cars.exceptions.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(value = "API Rest Cars", tags = "Cars")
public interface CarControllerOpenApi {

    @ApiOperation(value = "Lista carros da api externa")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Lista de carros retornada"),
    })
    List<CarOutputDTO> listAll() throws BusinessException;

    @ApiOperation(value = "Retorna carro da api externa")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Carro retornado"),
    })
    CarOutputDTO findById(@PathVariable("id") String id) throws BusinessException;

    @ApiOperation("Salva carros na api externa")
    @ApiResponses({
        @ApiResponse(code = 201, message = "Carro cadastrado"),
    })
    void save(@RequestBody CarInputDTO car) throws BusinessException;

    @ApiOperation("Atualiza carros na api externa")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Carro atualizado"),
    })
    void update(@PathVariable("id") String id, @RequestBody CarInputUpdateDTO car) throws BusinessException;

    @ApiOperation("Deleta carro na api externa")
    @ApiResponses({
        @ApiResponse(code = 204, message = "Carro deletado"),
    })
    void delete(@PathVariable("id") String id) throws BusinessException;
}
