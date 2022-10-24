package one.digitalinnovation.cloudparking.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.cloudparking.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.cloudparking.controller.dto.ParkingDTO;
import one.digitalinnovation.cloudparking.controller.mapper.ParkingMapper;
import one.digitalinnovation.cloudparking.model.Parking;
import one.digitalinnovation.cloudparking.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    //    poderia ser utilizado o autowired, mas é mais aconselhavel utilizar um construtor
    private final ParkingMapper parkingMapper;

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() {

        List<Parking> parkingsList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingsList);
//        retornando um codigo 200
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }

    @PostMapping
//    pegando um objeto limitado com os campos que preciso e retornando um objeto completo
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
//        preciso fazer o inverso, pegar o dto e transformar na entidade
//        tambem pode-se fazer com var
        var parkingCreate = parkingMapper.toParkingCreate(dto);
//        passando p o service
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
