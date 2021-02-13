package br.com.cars.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "log")
public class Log {

    private String id;
    private LocalDateTime data_hora = LocalDateTime.now();
    private String car_id;

}
