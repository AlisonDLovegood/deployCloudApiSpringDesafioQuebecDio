package one.digitalinnovation.cloudparking.controller;

import io.restassured.RestAssured;
import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTest {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());
//                verificar um item especidico: .body("license[0]", Matchers.equalTo("KIZ-8909"));
//                verificar se está tudo sendo retornado: .extract().response().body().prettyPrint();
    }

    @Test
    void whenCreateThenCheckIsCreated() {

        var crateDTO = new ParkingCreateDTO();
        crateDTO.setColor("AMARELO");
        crateDTO.setLicense("KIZ-2323");
        crateDTO.setModel("CORSA");
        crateDTO.setState("PE");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(crateDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("KIZ-2323"));
    }
}