package br.com.cars.controller.openapi;

import br.com.cars.document.Log;
import br.com.cars.exceptions.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@Api(value = "API Rest Logs", tags = "Logs")
public interface LogControllerOpenApi {

    @ApiOperation(value = "Lista Log da api")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Lista de log retornado"),
    })
    List<Log> listAll() throws BusinessException;

}
