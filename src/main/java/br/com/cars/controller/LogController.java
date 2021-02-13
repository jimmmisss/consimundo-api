package br.com.cars.controller;

import br.com.cars.controller.openapi.LogControllerOpenApi;
import br.com.cars.document.Log;
import br.com.cars.exceptions.BusinessException;
import br.com.cars.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/v1/logs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LogController implements LogControllerOpenApi {

    private final LogService logService;

    @GetMapping
    @ResponseStatus(OK)
    public List<Log> listAll() throws BusinessException {
        return logService.findAll();
    }
}
