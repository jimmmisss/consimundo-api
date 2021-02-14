package br.com.cars.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
public class Car {

    @Id
    private String _id;

    @Indexed(unique = true)
    private String title;
    private String brand;
    private String price;
    private Integer age;
}

