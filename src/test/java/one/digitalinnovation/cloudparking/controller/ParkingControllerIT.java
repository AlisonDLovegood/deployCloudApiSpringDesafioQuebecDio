package one.digitalinnovation.cloudparking.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

//fazer ocupar uma porta aleatoria p n ocupar a porta 8080 : boa pratica
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
//        utilizando a biblioteca do randomassure p encontrar a porta em que a app subiu
        RestAssured.port = randomPort;
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }
}