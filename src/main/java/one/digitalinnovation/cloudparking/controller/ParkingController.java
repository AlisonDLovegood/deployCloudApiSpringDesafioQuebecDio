package one.digitalinnovation.cloudparking.controller;

import one.digitalinnovation.cloudparking.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @GetMapping
    public List<Parking> findAll(){
        var parking = new Parking();
        parking.setColor("black");
        parking.setLicense("KIZ-8098");
        parking.setModel("corsa");
        parking.setState("PE");

        return List.of(parking);
    }

}
