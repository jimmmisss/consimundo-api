package br.com.cars.dto.input;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class CarInputUpdateDTO {

    @Indexed(unique = true)
    private String _id;

    @Indexed(unique = true)
    private String title;
    private String brand;
    private String price;
    private Integer age;

}
