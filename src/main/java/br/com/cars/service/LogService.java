package br.com.cars.service;

import br.com.cars.document.Log;
import br.com.cars.exceptions.BusinessException;
import br.com.cars.reposirory.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public List<Log> findAll() throws BusinessException {
        return logRepository.findAll();
    }
}
