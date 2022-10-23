package one.digitalinnovation.cloudparking.controller;

import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/parking")
public class ParkingController {

    //    poderia ser utilizado o autowired, mas é mais aconselhavel utilizar um construtor
    private final ParkingService parkingService;

    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public List<ParkingDTO> findAll(){
//        erro relatado por criar um objeto sem construtor, resolve ao criar um construtor sem parametros
//        var parking = new Parking();
//        parking.setColor("black");
//        parking.setLicense("KIZ-8098");
//        parking.setModel("corsa");
//        parking.setState("PE");
//
//        return List.of(parking);
        List<Parking> parkingsList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingsList);
    }

}
