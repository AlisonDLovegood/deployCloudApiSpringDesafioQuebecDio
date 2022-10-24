package one.digitalinnovation.cloudparking.controller;

import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/parking")
public class ParkingController {

    //    poderia ser utilizado o autowired, mas é mais aconselhavel utilizar um construtor
    private final ParkingMapper parkingMapper;

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(){

        List<Parking> parkingsList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingsList);
//        retornando um codigo 200
        return ResponseEntity.ok(result);
    }

}
