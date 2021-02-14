package br.com.cars.integration;

import br.com.cars.document.Car;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CarIntegrationV1Tests.FeignConfig.class)
@TestInstance(Lifecycle.PER_CLASS)
class CarIntegrationV1Tests {

    public static WireMockServer wireMockServer;

    @Autowired
    public CarIntegrationV1 carIntegrationV1;

    @BeforeAll
    public void setup() {
        wireMockServer = new WireMockServer(options().port(8090));
        wireMockServer.start();
    }

    @Test
    public void whenGetThenReturnListCars() {
        final var car = new Car("6025307886856a001c0b7cff", "corolla", "toyota", "100000", 2020);

        final var cars = carIntegrationV1.findAll();
        assertFalse(cars.isEmpty());
        assertThat(cars.get(0), is(car));

    }

    @EnableFeignClients(clients = CarIntegrationV1.class)
    @Configuration
    @EnableAutoConfiguration
    static class FeignConfig {
    }


}








